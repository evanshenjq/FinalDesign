<template>
<div  id="addBookPage">
  <admin-page-header/>
  <div class="row">
    <div class="col-md-offset-4">
      <h1>添加书籍</h1>
    </div>
  </div>
  <div class="row">
  <div class="col-md-offset-4 col-md-4">
    <form id="updateBookForm" enctype="multipart/form-data">
            <input type="hidden" name="id" v-model="id">
            <input type="hidden" name="created" v-model="created">            
            <div class="form-group">
               <label>图片</label>
              <input type="file" id="imageInput" @change="getImage()" ref="input" name="image" >
              <img :src="src" ref="img" id="preImage">
            </div>
            <div class="form-group">
              <label>书名</label>
              <input type="text" class="form-control input_med" id="nameInput" v-model="name" name="name" >
              <p v-if="showNameError">书名不能为空</p>
            </div>
            <div class="form-group">
              <label>作者</label>
              <input type="text" class="form-control " id="publishInput" v-model="publish" name="publish">
              <p v-if="showPublishError">作者不能为空</p>
            </div>
            <div class="form-group">
              <label>类型</label>
              <div class="row">
                <div class="col-md-4">
                <select class="form-control" id="catSelect" style="width:150px" v-model="catId" name="catId">
                  <option v-for="cat in cats" :value="cat.id">{{cat.id}}.{{cat.name}}</option>
                </select>
                </div>
              </div>
            </div>
            <div class="form-group">
              <label >价格</label>
               <div class="input-group">
                <span class="input-group-addon">￥</span>            
                <input type="text" class="form-control " id="priceInput" v-model="price" name="price">
               </div>
                <p v-if="showPriceError">价格必须为数字（两位小数）</p>
            </div>
            <div class="form-group">
              <label>库存</label>
              <div class="input-group">
                <input type="text" class="form-control " id="numInput" v-model="num" name="num">
                <span class="input-group-addon">本</span>
              </div>
              <p v-if="showNumError">价格必须为正整数</p>
            </div>
            <div class="form-group">
              <label>状态</label>
              <div class="row">
                <div class="col-md-4">
                <select class="form-control" id="statusSelect" v-model="status" name="status">
                  <option value=1>1.上架中</option>
                  <option value=2>2.待上架</option>
                  <option value=3>3.已下架</option>
                </select>
                </div>
              </div>
            </div>
            <div class="form-group">
              <label>描述</label>
              <textarea class="form-control" rows="3" id="descInput" v-model="descr" name="descr"></textarea>
            </div>
    </form>
    <button type="button" class="btn btn-warning" @click="submitUpdateBook()">提交</button>
  </div>
  </div>
</div>
</template>

<script>
var self;
import AdminPageHeader from "@/common/AdminPageHeader";
export default {
  components: {
    AdminPageHeader
  },
  data() {
    return {
      src: "",
      elInput: null,
      cats:"",
      showNameError:true,
      showPublishError:true,
      showNumError:true,
      showPriceError:true,
      name:"",
      publish:"",
      catId:"",
      num:"",
      price:"",
      descr:"",
      id:"",
      created:"",
      status:"",
      book:""
    };
  },
  watch:{
    name:function(){
      if(this.name!=""){
        this.showNameError=false;
      }else{
        this.showNameError=true;
      }
    },
    publish:function(){
      if(this.publish!=""){
        this.showPublishError=false;
      }else{
        this.showPublishError=true;
      }
    },
    num:function(){
      var regNum=/^([1-9]\d*|[0]{1,1})$/; 
      if(regNum.test(this.num)){
        this.showNumError=false;
      }else{
        this.showNumError=true;
      }
    },
    price:function(){
      var regPrice=/^[0-9]+([.]{1}[0-9]{1,2})?$/;
      if(regPrice.test(this.price)){
        this.showPriceError=false;
      }else{
        this.showPriceError=true;
      }
    },
  },
  mounted() {
    self=this;
    let bookId=this.$route.params.bookId;
    $("#preImage").hide();
    this.getBookCats();
    this.getBook(bookId);

  },
  methods: {
    getImage() {
      $("#preImage").show();
      const refs = this.$refs;
      const elInput = refs.input;
      const elImg = refs.img;
      const reader = new FileReader();
      reader.onload = e => {
        const src = e.target.result;
        elImg.src = src;
      };
      if (elInput.files && elInput.files[0]) {
        reader.readAsDataURL(elInput.files[0]);
      }
    },
    emptyForm() {
      $("addBookForm").form("clear");
      this.src = "";
    },
    getBookCats(){
      $.ajax({
			url:"/zstu/getBookCatsNoPage",
			type:"POST",
			success:function(result){
            self.cats=result.extend.cats;           
			}
      });
    },
    submitUpdateBook(){
        if(!this.showNameError&&!this.showPublishError&&!this.showNumError&&!this.showPriceError){
          var formData=new FormData(document.getElementById("updateBookForm"));
          console.log(formData.get('created'));
          $.ajax({
            url:"/zstu/updateBook",
            data:formData,
            type:"POST",
            contentType: false,
            processData: false,
            success:function(result){
              alert('更新成功');        
              self.$router.push('/bookPage');
            }
          });
        }
    },
    getBook(bookId){
        $.ajax({
            url:"/zstu/getBook/"+bookId,
			type:"POST",
			success:function(result){
                self.book=result.extend.book;     
                if(result.extend.book.image!=""){
                    $("#preImage").show();
                    self.src=self.book.image;
                }
                self.id=self.book.id;
                self.created=self.book.created;
                self.name=self.book.name;
                self.publish=self.book.publish;
                self.catId=self.book.catId;
                self.price=self.book.price;
                self.num=self.book.num;
                self.status=self.book.status;
                self.descr=self.book.descr;      
			}
        });
    }
  }
};
</script>

<style>
#preImage {
  width: 130px;
  height: 150px;
}
p{
  color: red;
}
#addBookPage{
  margin-bottom: 70px;
}
</style>







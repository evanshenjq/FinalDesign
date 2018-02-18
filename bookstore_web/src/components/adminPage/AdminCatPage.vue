<template>
  <div class="col-md-10">
      <!-- 模态框 -->
      <!-- 添加模态框 -->
      <div class="modal fade" tabindex="-1" role="dialog" id="addModal">
        <div class="modal-dialog modal-sm" role="document">
            <div class="modal-content">
            <div class="modal-body">
                <div class="form-group">
                    <label>类目名</label>
                    <input type="text" class="form-control input_med" id="addNameInput" v-model="addName">
                    <p v-if="showAddNameError">类目名不能为空</p>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" @click="submitAddCat()">保存</button>
            </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
      <!-- 更新模态框 -->
      <div class="modal fade" tabindex="-1" role="dialog" id="updateModal">
        <div class="modal-dialog modal-sm" role="document">
            <div class="modal-content">
            <div class="modal-body">
                <div class="form-group">
                    <label>类目名</label>
                    <input type="text" class="form-control input_med" id="nameInput" v-model="name">
                    <input type="hidden" id="idInput" v-model="id">
                    <p v-if="showNameError">类目名不能为空</p>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" @click="submitUpdateCat()">保存</button>
            </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->


      <div class="row">
        <!-- 表格栏 -->
        <div class="col-md-4">
            <!-- 书籍列表 -->
            <div>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>类目名</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="cat in cats">
                            <td>{{cat.id}}</td>
                            <td>{{cat.name}}</td>
                            <td>
                                <button class="btn btn-info glyphicon glyphicon-pencil btn-xs" @click="updateCat(cat.id)"></button>
                                <button class="btn btn-danger glyphicon glyphicon-remove btn-xs" @click="deleteCat(cat.id)"></button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <!-- 分页文字信息 -->
            <div id="page_info">
                当前{{nowPage}}页,总{{totalPage}}页,总共{{total}}条记录
            </div>
            <!-- 分页条 -->
            <div id="page_nav">
                <ul class="pagination" >
                    <li id="firstPageLi">
                    <a href="#">
                        首页
                    </a>
                    </li>
                    <li id="prePageLi">
                    <a href="#">
                        &laquo;
                    </a>
                    </li>
                    <li v-for="pageNum in pageNums">
                        <a href="#" @click="toPage(pageNum)">{{pageNum}}</a>
                    </li>
                    <li  id="nextPageLi">
                    <a href="#" >
                        &raquo;
                    </a>
                    </li>
                    <li id="lastPageLi">
                    <a href="#" >
                        末页
                    </a>
                    </li>
                </ul>
            </div>
        </div>
        <!-- 功能栏 -->
        <div class="col-md-5" id="function_div">
            <div>
                <div class="row">
                    <div class="col-md-offset-1">
                        <button type="button" class="btn btn-success glyphicon glyphicon-plus" @click="addCatModal()">添加</button>
                    </div>
                </div>
                <div class="row" id="search_div">
                    <div class="input-group input-group-sm col-md-8 col-md-offset-1">
                        <input type="text" class="form-control" aria-label="...">
                        <div class="input-group-btn">
                        <button type="button" class="btn btn-default">搜索</button>
                        </div>
                    </div>
                </div>
                <div class="row" id="search_choice">
                    <div class="col-md-offset-1">
                        <input type="radio" name="radio" value="1" checked>ID
                        <input type="radio" name="radio" value="2">书名
                    </div>
                </div>
            </div>
           
        </div>
      </div>
  </div>
</template>

<script>
var self;
export default {
    data() {
        return {
            cats:'',
            nowPage:'',
            totalPage:'',
            total:'',
            pageNums:[],
            name:'',
            addName:'',
            id:'',
            showNameError:true,
            showAddNameError:true
        };
    },
    mounted() {
        self=this;
        this.toPage(1);
    },
    watch:{
        name:function(){
        if(this.name!=""){
            this.showNameError=false;
        }else{
            this.showNameError=true;
        }
        },
        addName:function(){
        if(this.addName!=""){
            this.showAddNameError=false;
        }else{
            this.showAddNameError=true;
        }
        }
    },
    methods: {
        toPage(pn){
            $.ajax({
				url:"/zstu/getBookCats",
				data:{'pn':pn},
				type:"POST",
				success:function(result){
                    //console.log(result);
                    self.cats=result.extend.cats.list;
                    //2.解析显示分页信息
                    self.nowPage=result.extend.cats.pageNum;
                    self.totalPage=result.extend.cats.pages;
                    self.total=result.extend.cats.total;
                    //3.解释显示分页条
                    self.buildPageNav(result);            
				}
            });
       },
       buildPageNav(result){
           this.resetPage();
           self.pageNums=result.extend.cats.navigatepageNums;
           if(!result.extend.cats.hasPreviousPage){
               $('#firstPageLi').addClass('disabled');
               $('#prePageLi').addClass('disabled');
           }else{
               $('#firstPageLi').click(function(){
                   self.toPage(1);
               });
               $('#prePageLi').click(function(){
                   self.toPage(result.extend.cats.pageNum-1);
               })
           }
            if(!result.extend.cats.hasNextPage){
               $('#lastPageLi').addClass('disabled');
               $('#nextPageLi').addClass('disabled');
           }else{
               $('#lastPageLi').click(function(){
                   self.toPage(result.extend.cats.pages);
               });
               $('#nextPageLi').click(function(){
                   self.toPage(result.extend.cats.pageNum+1);
               })
           }
        },
        resetPage(){
            $('#firstPageLi').removeClass('disabled');
            $('#prePageLi').removeClass('disabled');
            $('#lastPageLi').removeClass('disabled');
            $('#nextPageLi').removeClass('disabled');
        },
        updateCat(id){
            $.ajax({
                url:"/zstu/getBookCat/"+id,
                type:"POST",
                success:function(result){
                    $('#updateModal').modal('show');
                    self.id=result.extend.cat.id;
                    self.name=result.extend.cat.name;
                }
            });
        },
        submitUpdateCat(){
            if(!this.showNameError){
                let formData=new FormData();
                formData.append('id',this.id);
                formData.append('name',this.name);
                console.log(this.id);
                console.log(this.name);
                $.ajax({
                    url:"/zstu/updateBookCat",
                    data:formData,
                    type:"POST",
                    contentType: false,  
                    processData: false,
                    success:function(result){
                        alert("更新成功！");
                        location.reload();
                    }
                });
            }
        },
        addCatModal(){
            $('#addModal').modal('show');
        },
        submitAddCat(){
            if(!this.showAddNameError){
                let formData=new FormData;
            formData.append('name',this.addName);
            $.ajax({
                url:"/zstu/addBookCat",
                data:formData,
                type:"POST",
                contentType: false,  
                processData: false,
                success:function(result){
                    alert("添加成功！");
                    location.reload();
                }
            });
            } 
        },
        deleteCat(id){
            if(confirm("确认删除ID为"+id+"的类目吗?")){
               $.ajax({
                   url:"/zstu/deleteBookCat/"+id,
                   type:"POST",
                   success:function(result){
                       alert(result.extend.mes);
                       location.reload();
                   }
               })
           }
        }
  }
};
</script>

<style>
#function_div{
    margin-top: 20px;
}
#search_div{
    margin-top:40px;
}
p{
    color: red;
}
</style>

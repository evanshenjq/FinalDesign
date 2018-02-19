<template>
  <div class="col-md-10">
    <!-- 模态框 -->
      <!-- 新书推荐模态框 -->
      <div class="modal fade" tabindex="-1" role="dialog" id="newBookModal">
        <div class="modal-dialog modal-sm" role="document">
            <div class="modal-content">
            <div class="modal-body">
                <div class="form-group">
                    <label>书籍编号</label>
                    <input type="number" class="form-control input_med" v-model="newBook">
                    <p v-if="showNewBookError">该书籍编号不存在</p>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" @click="submitUpdateNewBookId()">保存</button>
            </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

    <!-- 热门推荐模态框 -->
      <div class="modal fade" tabindex="-1" role="dialog" id="hotBookModal">
        <div class="modal-dialog modal-sm" role="document">
            <div class="modal-content">
            <div class="modal-body">
                <div class="form-group">
                    <label>书籍编号</label>
                    <input type="number" class="form-control input_med" v-model="hotBook">
                    <p v-if="showHotBookError">该书籍编号不存在</p>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" @click="submitUpdateHotBookId()">保存</button>
            </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

    <div class="row">
      <!-- 新书推荐 -->
      <div class="col-md-4">
        <div>
          <h2 class="index_title">新书推荐</h2>
        </div>
        <div>
          <table class="table table-hover">
            <thead>
              <tr>
                <th>ID</th>
                <th>书籍ID</th>
                <th>操作</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="newBookId in newBookIds">
                <td>{{newBookId.id}}</td>
                <td>{{newBookId.bookId}}</td>
                <td>
                  <button class="btn btn-info glyphicon glyphicon-pencil btn-xs" @click="updateNewBook(newBookId.id,newBookId.bookId)"></button>
                </td>
              </tr>
            </tbody>
         </table>
        </div>
      </div>

      <!-- 热门推荐 -->
      <div class="col-md-4 col-md-offset-1">
        <div>
          <h2 class="index_title">热门推荐</h2>
        </div>
        <div>
          <table class="table table-hover">
            <thead>
              <tr>
                <th>ID</th>
                <th>书籍ID</th>
                <th>操作</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="hotBookId in hotBookIds">
                <td>{{hotBookId.id}}</td>
                <td>{{hotBookId.bookId}}</td>
                <td>
                  <button class="btn btn-info glyphicon glyphicon-pencil btn-xs" @click="updateHotBook(hotBookId.id,hotBookId.bookId)"></button>
                </td>
              </tr>
            </tbody>
         </table>
        </div>

      </div>
    </div>
  </div>
</template>

<script>
var self;
export default {
  data(){
    return{
      newBookIds:'',
      hotBookIds:'',
      newBook:'',
      hotBook:'',
      newId:'',
      hotId:'',
      showNewBookError:true,
      showHotBookError:true
    }
  },
  mounted(){
    self=this;
    this.getNewBooksId();
    this.getHotBooksId();

  },
  watch:{
    newBook:function(){
      $.ajax({
        url:"/zstu/hasBookId/"+this.newBook,
        type:"POST",
        success:function(result){
          if(result.extend.hasId){
            self.showNewBookError=false;
          }else{
            self.showNewBookError=true;
          }
        }
      });
    },
    hotBook:function(){
      $.ajax({
        url:"/zstu/hasBookId/"+this.hotBook,
        type:"POST",
        success:function(result){
          if(result.extend.hasId){
            self.showHotBookError=false;
          }else{
            self.showHotBookError=true;
          }
        }
      });
    },
  },
  methods:{
    getNewBooksId(){
      $.ajax({
        url:"/zstu/getNewBooksId",
        type:"POST",
        success:function(result){
          self.newBookIds=result.extend.newBookId;
        }
      });
    },
    getHotBooksId(){
      $.ajax({
        url:"/zstu/getHotBooksId",
        type:"POST",
        success:function(result){
          self.hotBookIds=result.extend.hotBookId;
        }
      });
    },
    updateHotBook(id,bookId){
      $('#hotBookModal').modal('show');
      this.hotBook=bookId;
      this.hotId=id;
    },
    updateNewBook(id,bookId){
      $('#newBookModal').modal('show');
      this.newBook=bookId;
      this.newId=id;
    },
    submitUpdateNewBookId(){
      if(!this.showNewBookError){
        let formData=new FormData();
        formData.append('id',this.newId);
        formData.append('newBook',this.newBook)
        $.ajax({
          url:"/zstu/updateNewBookId",
          data:formData,
          type:"POST",
          contentType: false,  
          processData: false,
          success:function(result){
            alert("更新成功!");
            location.reload();
          }
        });
      }
    },
    submitUpdateHotBookId(){
      if(!this.showHotBookError){
        let formData=new FormData();
        formData.append('id',this.hotId);
        formData.append('hotBook',this.hotBook)
        $.ajax({
          url:"/zstu/updateHotBookId",
          data:formData,
          type:"POST",
          contentType: false,  
          processData: false,
          success:function(result){
            alert("更新成功!");
            location.reload();
          }
        });
      }
    }
  }
  
}
</script>

<style>
.index_title{
  margin-bottom: 20px;
}
p{
  color:red;
}
</style>

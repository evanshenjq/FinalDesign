<template>
    <div class="row">
        <div class="col-md-offset-1" id="order_address_page">
            <h2>请选择你的地址</h2>
            <div class="row" id="order_address_form">
                <div class="col-md-4">
                    <form>
                        <div class="form-group">
                            <label for="exampleInputEmail1">姓名</label>
                            <input type="text" class="form-control" v-model="name">
                             <p v-if="showNameError">姓名不能为空</p>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">收货地址</label>
                            <input type="text" class="form-control" v-model="address">
                             <p v-if="showAddressError">地址不能为空</p>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">联系电话</label>
                            <input type="text" class="form-control" v-model="phone">
                            <p v-if="showPhoneError">电话不能为空</p>
                        </div>
                        <button type="button" class="btn btn-warning" @click="goOrderConfirmPage()">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
var self;
var userId;
export default {
    data(){
        return{
            name:'',
            address:'',
            phone:'',
            showPhoneError:true,
            showNameError:true,
            showAddressError:true
        }
    },
    mounted(){
        userId=sessionStorage.getItem("userId");
        self=this;
        this.getUserInfo();
    },
    watch:{
        name:function(){
            if(this.name!=null){
                this.showNameError=false;
            }else{
                this.showNameError=true;
            }
        },
        address:function(){
            if(this.address!=null){
                this.showAddressError=false;
            }else{
                this.showAddressError=true;
            }
        },
        phone:function(){
            if(this.phone!=null){
                this.showPhoneError=false;
            }else{
                this.showPhoneError=true;
            }
        }
    },
    methods:{
        getUserInfo(){
            if(this.$route.params.name!=null){
                this.name=this.$route.params.name;
                this.address=this.$route.params.address;
                this.phone=this.$route.params.phone;
            }else{
                $.ajax({
                url:"/zstu/getUserById/"+userId,
                type:"POST",
                success:function(result){
                    let user=result.extend.user;
                    self.name=user.username;
                    self.phone=user.phone;
                    self.address=user.address;
                }
                });
            }
        },
        goOrderConfirmPage(){
            if(!this.showPhoneError&&!this.showNameError&&!this.showAddressError){
                let orderName=this.name;
                let orderPhone=this.phone;
                let orderAddress=this.address;
                this.$router.push({
                    name:'userOrderConfirm',
                    params:{
                        name:orderName,
                        phone:orderPhone,
                        address:orderAddress
                }
            });
            }else{
                alert("请完成完整的订单信息");
            }
            
        }
    }
}
</script>


<style>
#order_address_form{
    margin-top: 20px;
}
p{
    color:red;
}
</style>

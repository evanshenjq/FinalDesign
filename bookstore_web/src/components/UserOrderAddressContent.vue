<template>
    <div class="row">
        <div class="col-md-offset-1" id="order_address_page">
            <h2>请选择你的地址</h2>
            <div class="row" id="order_address_form">
                <div class="col-md-4">
                    <form>
                        <div class="form-group">
                            <label for="exampleInputEmail1">姓名</label>
                            <input type="email" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">收货地址</label>
                            <input type="password" class="form-control" >
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">联系电话</label>
                            <input type="password" class="form-control">
                        </div>
                        <button type="submit" class="btn btn-warning" @click="goOrderConfirmPage()">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    data(){
        return{

        }
    },
    mounted(){

    },
    methods:{
        goOrderConfirmPage(){
            let name="moses";
            let phone="15958003138";
            let address="123"
            this.$router.push({
                name:'userOrderConfirm',
                params:{
                    name:name,
                    phone:phone,
                    address:address
                }
            });
        }
    }
}
</script>


<style>
#order_address_form{
    margin-top: 20px;
}
</style>

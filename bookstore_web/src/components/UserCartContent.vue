<template>
  <div class="row">
      <div class="col-md-offset-1" id="cart_title">
        <h2>购物车</h2>
      
        <div class="row" id="sc_list_title">        
                <div class="col-md-1 col-md-offset-7">价格</div>
                <div class="col-md-1 col-md-offset-2">数量</div>
        </div>

        <div class="row" id="sc_list_body">
            
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
        this.getUserCart();
    },
    methods:{
        getUserCart(){
            let userId=sessionStorage.getItem('userId');
            $.ajax({
                url:"/zstu/getCart/"+userId,
                type:"POST",
                success:function(result){
                    console.log(result);
                }
            });
        },
    }
}
</script>

<style>
#sc_list_title{
    border-bottom-style:solid;
    border-bottom-width: 1px;
    border-bottom-color: #dddddd;
    width:90%;
}
</style>

<template>
  
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

</style>

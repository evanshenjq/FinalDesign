<template>
  <div class="footer_info row">
      <div class="row footer_content">
        <div class="col-md-offset-4 col-md-1">
            <footerTitle>了解我们</footerTitle>
            <button class="btn btn-link">关于我们</button>
        </div>
        <div class="col-md-1">
            <footerTitle >帮助中心</footerTitle>
            <button class="btn btn-link">订单查询</button>
            <button class="btn btn-link">退换货</button>
        </div>
        <div class="col-md-1">
            <footerTitle >支付方式</footerTitle>
            <div class="font_style">支付宝</div>
            <div class="font_style">微信</div>
            <div class="font_style">银行卡</div>
        </div>
        <div class="col-md-1">
            <footerTitle>管理员中心</footerTitle>
            <button class="btn btn-link">管理员入口</button>
        </div>
      </div>
      <div class="author">@ztsu.sjq.final.design</div>
  </div>
</template>

<script>
export default {
  
}
</script>

<style>
.footer_info{
    margin-top:100px;
    border-top-style:solid;
    border-top-width: 0.8px;
    border-top-color: #dddddd;
}
.footer_content{
    margin-top:35px;
    margin-bottom: 25px;
}
footerTitle{
    font-size: 17px;
    font-weight: 500;
    margin-left: 12px;
}
.author{
    text-align: center;
}
.font_style{
    padding-top: 6px;
    padding-right: 12px;
    padding-bottom: 6px;
    padding-left: 12px;
    font-size: 14px;
    font-weight: 400;
}
</style>


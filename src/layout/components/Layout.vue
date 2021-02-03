<template>
  <div class="main">
    <div class="header"><slot name="Header"></slot></div>
    <div class="body"><slot name="Body"></slot></div>
    <div class="footer"><slot name="Footer"></slot></div>
  </div>
</template>

<script>
export default {
name: "appMainLayout"
}
</script>

<style scoped lang="scss">
.header{
  position: relative;
  width: 100%;
  height: 50px;
  background-color: white;
}
.body{
  width: 100%;
  height: calc(100vh - 130px);
}
.footer{
  position: absolute;
  bottom: 10px;
  width: 99%;
  height: 40px;
  background-color: #1f2d3d;
}
</style>

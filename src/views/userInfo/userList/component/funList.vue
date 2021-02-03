<template>
<div class="main">
  <div class="leftFunction">
    <el-button type="success">添加用户</el-button>
    <el-input v-model="input" placeholder="用户名/账号" class="input"></el-input>
    <el-button type="primary">搜索</el-button>
  </div>
  <div class="rightFunction">
    <el-button type="primary">导出</el-button>
  </div>
</div>
</template>

<script>
export default {
name: "funList",
  data(){
  return{
    input:'',//输入框
  }
  }
}
</script>

<style scoped lang="scss">
.main{
  width: 100%;
  height: 100%;
  display: flex;
  align-items: center;
  .leftFunction{
    height: 100%;
    flex: 3;
    display: flex;
    align-items: center;
    padding-left: 20px;
    .input{
      margin-left: 40px;
      width: 20%;
    }
  }
  .rightFunction{
    height: 100%;
    flex: 1;
    display: flex;
    align-items: center;
    justify-content: flex-end;
    padding-right: 20px;
  }
}
</style>

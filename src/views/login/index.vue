<template>
<!--登陆页面-->
  <div class="main">
    <div class="box">
<!--      头部样式-->
      <div class="head">
        <h1>LOGIN</h1>
      </div>
<!--      输入表单-->
      <div class="input">
        <div class="inputBox"><el-input @focus="changeColor(dom[0])" style="width: 100%;" v-model="form.username" placeholder="User" clearable autocomplete prefix-icon="el-icon-user"/></div>
        <div class="inputBox" @keydown.enter="login"><el-input @focus="changeColor(dom[1])" style="width: 100%" v-model="form.password" placeholder="Password" type="password" clearable show-password autocomplete prefix-icon="el-icon-lock"/></div>
        <el-button type="primary" class="btn" @click="login">登陆</el-button>
      </div>

    </div>
  </div>
</template>
<script>
export default {
  name: "index",
  data(){
    return {
      //user login form
      dom:[],//表单
      form:{
        username:'',// username
        password:''//password
      }
    }
  },
  methods:{
    /**
     * 改变 dom颜色
     * @param dom
     * @param type
     */
    changeColor(dom,type){
      if(type === 'error'){
        dom.style.color = 'darkred'
        dom.style.borderColor = 'darkred'
      }else{
        dom.style.color = 'white'
        dom.style.borderColor = '#7b838c'
      }
    },
      login(){
       if(this.form.username === ''||this.form.password===''){
         this.dom.forEach(item=>{
           this.changeColor(item,'error')
         })
         this.$message.error('账号或密码不能为空')
       }else{
        this.$store.dispatch('user/logIn',this.form).then(()=>{
          this.$router.push('/')
        })
       }

    }
  },
  mounted() {
    this.dom = document.getElementsByClassName('el-input__inner')
  }
}
</script>

<style scoped lang="scss">
.main{
  width: 100%;
  height: 100%;
  background-color: #283443;
  display: flex;
  justify-content: center;
  align-items: center;
  .box{
    width: 30%;
    height: 50%;
    transition: all ease-in-out 0.5s;
    border-radius: 10px;
    display: flex;
    justify-content: start;
    flex-direction: column;
    align-items: center;
    h1{
      margin-top: 50px;
      color: #6ae8fd;
      letter-spacing: 5px;
      user-select: none;
    }
    .input{
      margin-top: 30px;
      width: 70%;
      height: 40%;
      display: flex;
      flex-direction: column;
      justify-content: space-between;
      .inputBox{
        display: flex;
        justify-content: space-between;
      }
      .btn{
        margin-top: 3px;
        width: 100%;
      }
    }
  }
::v-deep .el-input{
  .el-input__inner{
    background-color: #1f2d3d;
    border-color: #7b838c;
    color: white;
  }
}
  ::v-deep  .el-input__inner .error{
    border-color: darkred;
    color: darkred;
  }
}
</style>

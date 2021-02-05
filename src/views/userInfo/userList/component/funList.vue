<template>
<div class="main">
  <div class="leftFunction">
    <el-button type="success" icon="el-icon-plus" @click="dialogVisible = !dialogVisible">添加用户</el-button>
    <el-input v-model="input" placeholder="用户名/账号" class="input"></el-input>
    <el-button icon="el-icon-search" />
  </div>
  <div class="rightFunction">
    <el-button type="info" icon="el-icon-download">导出</el-button>
  </div>
  <el-dialog
      title="添加用户"
      :visible.sync="dialogVisible"
      width="30%"
      :before-close="close"
      >
    <el-form size="mini" ref="form" :model="form" label-width="100px" :rules="rules" label-position="right" hide-required-asterisk status-icon>
      <el-form-item prop="user" label="用户名称"><el-input v-model="form.user" placeholder="输入用户名字" size="medium" style="width: 95%" /></el-form-item>
      <el-form-item prop="username" label='用户账号'><el-input v-model="form.username" placeholder="用户账号" size="medium" style="width: 95%" /></el-form-item>
      <el-form-item prop="password" label="用户密码"><el-input v-model="form.password" placeholder="用户密码" size="medium" style="width: 95%" /></el-form-item>
      <el-form-item prop="phone" label="电话"><el-input v-model="form.phone" placeholder="电话号码" size="medium" style="width: 95%" /></el-form-item>
      <el-form-item prop="address" label="地址"><el-input v-model="form.address" placeholder="地址" size='medium' style="width: 95%" /></el-form-item>
      <el-form-item prop="email" label="电子邮箱"><el-input v-model="form.email" placeholder="电子邮箱" size='medium' style="width: 95%" /></el-form-item>
      <el-form-item prop="money" label="充值金额"><el-input v-model="form.money" placeholder="充值金额" size='medium' style="width: 95%" /></el-form-item>

    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button type="primary" @click="confirm" size="mini">确 定</el-button>
      <el-button @click="reset" size="mini">重 置</el-button>
      <el-button @click="close" size="mini">取 消</el-button>
    </span>
  </el-dialog>
</div>
</template>

<script>
import { createUser } from '@/api/user'
import NProgress from 'Nprogress'
export default {
name: "funList",
  data(){
    const emailREX = /^[0-9a-zA-Z_-](\w)+@[0-9a-zA-Z_-]+\.[a-z]{2,3}$/ //邮箱验
    const phoneREX = /^1+[3-9]+[0-9]{9}/ //电话号
    const passwordREX = /^(\w){5,16}/ //密码
    /**
     *邮箱验证
     * @param rule
     * @param value
     * @param callback
     * @returns {*}
     */

    const emailTest = (rule,value,callback)=>{
      if(!emailREX.test(value)){
        return callback(new Error('邮箱地址不合法'))
      }
      callback()
    }
    /**
     * 电话验证
     * @param rule
     * @param value
     * @param callback
     * @returns {*}
     */
    const phoneTest = (rule,value,callback)=>{
      if(!phoneREX.test(value)){
        return callback(new Error('电话号码不合法'))
      }
      callback()
    }
    /**
     * 密码格式验证
     * @param rule
     * @param value
     * @param callback
     * @returns {*}
     */
    const passwordTest = (rule,value,callback)=>{
      if(value.length<6||value.length>16){
        return callback(new Error('密码长度在6-16之间'))
      }
      else if(!passwordREX.test(value)){
        return callback('密码只能为字母、数字、下划线')
      }
    }
  return{
    input:'',//输入框
    dialogVisible:false,
    form:{//添加用户表单
      user:'',//用户名字
      money:'',//充值金额
    },
    rules:{
      user:{required:true,message:'请输入用户名称',trigger:'blur'},
      username: {required: true,message: '请设置登陆账户',trigger: 'blur'},
      password:[
        {required:true,message: '密码不能为空'},
        {validator:passwordTest,trigger: 'blur'}],
      email:[
        {required:true,message:'邮箱不能为空'},
        {validator:emailTest,trigger:'blur'},
      ],
      phone:[
        {required:true,message:'电话号码不能为空'},
        {validator:phoneTest,trigger:'blur'}
      ]
    }
  }
  },
  methods:{
   async confirm(){
     NProgress.start()//提交进度条开始
      this.$refs.form.validate()
      const res = await createUser(this.form)
      if(res.code === 200){
         location.reload()
         this.dialogVisible = false
         NProgress.done()//提交进度条结束
      }
    },
    /**
     * 关闭按钮
     */
    close: function () {
      this.$confirm('确认关闭？').then(_=>{
        this.dialogVisible = false
        this.reset()
        NProgress.done()//提交进度条结束
      }).catch(_ => {})
    },
    /**
     * 重置按钮
     */
    reset(){
      this.$refs.form.resetFields()
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
  .dialog-footer{
    display: flex;
    justify-content: center;
  }
}
</style>

<template>
<div style="width: 100%;height: 100%;margin-top: 10px;">
<!--  数据表单-->
  <el-table
      :data="data"
      style="width: 100%"
      height="calc(100% - 50px)"
      border
      stripe
      v-loading="loading"
      size="medium"
  >
    <el-table-column prop="name" label="用户名称" min-width="80" align="center"/>
    <el-table-column prop="username" label="账号" min-width="80" align="center"/>
    <el-table-column prop="password" label="密码" min-width="80" align="center"/>
    <el-table-column prop="email" label="邮箱" min-width="150" align="center"/>
    <el-table-column prop="address" label="邮递地址" min-width="150" align="center"/>
    <el-table-column label="允许登陆" min-width="80" align="center">
      <template slot-scope="scops">
        <el-switch v-model="scops.row.online" active-color="#13ce66" inactive-color="#ff4949" @change="changeType(scops.row)"></el-switch>
      </template>
    </el-table-column>
    <el-table-column prop="create_time" label="创建时间" min-width="150" align="center"/>
    <el-table-column prop="phone" label="电话号" min-width="80" align="center"/>
    <el-table-column prop="money" label="积分" min-width="80" align="center"/>
    <el-table-column  label="操作" min-width="150" align="center">
      <template slot-scope="scops">
        <el-button type="primary" icon="el-icon-edit" @click="edit(scops.row)" size="mini"/>
        <el-button type="info" icon="el-icon-s-finance" @click="editMoney(scops.row)" size="mini"/>
        <el-button type="danger" icon="el-icon-delete" @click="deleteUser(scops.row)" size="mini"/>
      </template>
    </el-table-column>
  </el-table>
  <el-dialog
          title="修改用户信息"
          :visible.sync="dialogVisible"
          width="30%"
          :before-close="close"
  >
    <el-form size="mini" :rules="rules" :model="form" label-width="100px"  label-position="right" hide-required-asterisk status-icon>
      <el-form-item prop="user" label="用户名称"><el-input v-model="form.name" placeholder="输入用户名字" size="medium" style="width: 95%" /></el-form-item>
      <el-form-item prop="username" label='用户账号'><el-input v-model="form.username" placeholder="用户账号" size="medium" style="width: 95%" /></el-form-item>
      <el-form-item prop="password" label="用户密码"><el-input v-model="form.password" placeholder="用户密码" size="medium" style="width: 95%" /></el-form-item>
      <el-form-item prop="phone" label="电话"><el-input v-model="form.phone" placeholder="电话号码" size="medium" style="width: 95%" /></el-form-item>
      <el-form-item prop="address" label="地址"><el-input v-model="form.address" placeholder="地址" size='medium' style="width: 95%" /></el-form-item>
      <el-form-item prop="email" label="电子邮箱"><el-input v-model="form.email" placeholder="电子邮箱" size='medium' style="width: 95%" /></el-form-item>
      <el-form-item prop="money" label="充值金额"><el-input v-model="form.money" placeholder="充值金额" size='medium' style="width: 95%" /></el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button type="primary" @click="confirm" size="mini">确 定</el-button>
      <el-button @click="close" size="mini">取 消</el-button>
    </span>
  </el-dialog>
<!--  修改金钱-->
  <el-dialog
      title='输入金额'
      :visible.sync="moneyDialog"
      width="30%"
      :before-close="closeMoneyDialog"
  >
    <el-input v-model="moneyForm.money" type="number"/>
    <span slot="footer" class="dialog-footer">
      <el-button type="primary" @click="changeMoney" size="mini">确 定</el-button>
      <el-button @click="closeMoneyDialog" size="mini">取 消</el-button>
    </span>
  </el-dialog>
</div>
</template>

<script>
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'
import {deleteUser,updateUser,changeType,updateMoney} from "@/api/user";

export default {

  name: "bodyForm",
  props:{
    data:Array,//数据
    loading:Boolean,//正在读取
    tempData:Object//临时保存数据
  },
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
    return {
      dialogVisible : false,
      form:{},//修改表单
      moneyForm:{
        id:'',
        money:0
      },//显示改变金钱
      moneyDialog:false,//显示改变金额
      rules:{
        name:{required:true,message:'请输入用户名称',trigger:'blur'},
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
    /**
     * 显示编辑裱框
     * */
     edit (obj){
      this.dialogVisible = true
      this.form = obj
    },
    /**
     * 删除用户
     * */
    deleteUser(obj){
      this.$confirm(`确认删除\n${obj.name}?`).then(_=>{
        this.deleteUserConfirm(obj)
      }).catch(_=>{})
    },
    /**
     * 删除确认
     * */
    async deleteUserConfirm (obj){
      const res = await deleteUser({
        id:obj.id
      })
      if(res.meta.code === 130){
        this.$message.success(res.meta.msg)
        return this.$emit('reload')
      }else{
       return  this.$message.error(res.meta.msg)
      }
    },
    /**
     * 显示修改金额对话框
     * */
    editMoney(obj){
      this.moneyDialog = true
      this.moneyForm.money = obj.money
      this.moneyForm.id = obj.id
    },
    /**
     * 确认修改金额
     * */
    async changeMoney(){
       const res = await updateMoney({
         id:this.moneyForm.id,
         money: this.moneyForm.money
       })
      if(res.meta.code === 121){
        this.moneyDialog = false
        this.$emit('reload')
        return this.$message.success(res.meta.msg)
      }
      return this.$message.error(res.meta.msg)
    },
    /**
     * 确认更改
     * */
    async confirm (){
      const res = await updateUser(this.form)
      if(res.meta.code === 120){
        this.$emit('reload')
        this.dialogVisible = false
        return this.$message.success(res.meta.msg)
      }else{
        return this.$message.error(res.meta.msg)
      }
    },
    async changeType(obj){
      let type = obj.online
      const res = await changeType({
        id:obj.id,
        type:type
      })
    },
    /**
     * 关闭修改信息对话框
     */
    close: function () {
      this.$confirm('确认关闭？').then(_=>{
        this.dialogVisible = false
        this.reset()
        NProgress.done()//提交进度条结束
      }).catch(_ => {})
    },
    /**
     * 关闭修改金钱对话框
     */
    closeMoneyDialog:function (){
      this.$confirm('确认关闭？').then(_=>{
        this.moneyDialog = false
      }).catch(_ => {})
    }
  }
}
</script>

<style scoped lang="scss">
.item{
  margin-left: 10px;
}
</style>

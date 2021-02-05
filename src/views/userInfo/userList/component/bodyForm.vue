<template>
<div style="width: 100%;height: 100%;margin-top: 10px;">
  <el-table
      :data="data"
      style="width: 100%"
      height="calc(100% - 50px)"
      border
      stripe
      v-loading="loading"
  >
    <el-table-column prop="id" label="用户Id" min-width="80" align="center"/>
    <el-table-column prop="name" label="用户名称" min-width="80" align="center"/>
    <el-table-column prop="username" label="账号" min-width="80" align="center"/>
    <el-table-column prop="password" label="密码" min-width="80" align="center"/>
    <el-table-column prop="email" label="电子邮件" min-width="80" align="center"/>
    <el-table-column prop="address" label="邮递地址" min-width="80" align="center"/>
    <el-table-column prop="level" label="等级" min-width="80" align="center"/>
    <el-table-column prop="createTime" label="创建时间" min-width="80" align="center"/>
    <el-table-column prop="telephone" label="电话号" min-width="80" align="center"/>
    <el-table-column prop="integral" label="积分" min-width="80" align="center"/>
    <el-table-column  label="操作" min-width="100" align="center">
      <template slot-scope="scops">
        <el-button type="primary" icon="el-icon-edit" @click="dialogVisible = !dialogVisible" size="mini"/>
        <el-button type="danger" icon="el-icon-delete" size="mini"/>
      </template>
    </el-table-column>
  </el-table>
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
export default {
  name: "bodyForm",
  props:{
    data:Array,
    loading:Boolean
  },
  data(){
    return {
      dialogVisible : true,
      form:{}
    }
  }
}
</script>

<style scoped lang="scss">
.item{
  margin-left: 10px;
}
</style>

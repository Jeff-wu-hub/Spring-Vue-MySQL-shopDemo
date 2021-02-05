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
    <el-table-column  label="操作" min-width="100" align="center">
      <template slot-scope="scops">
        <el-button type="primary" icon="el-icon-edit" size="mini"/>
        <el-button type="danger" icon="el-icon-delete" size="mini"/>
      </template>
    </el-table-column>
  </el-table>
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

    }
  }
}
</script>

<style scoped lang="scss">
.item{
  margin-left: 10px;
}
</style>

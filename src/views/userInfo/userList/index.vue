<template>
<Layout>
  <fun-list slot="Header" @select="select($event)"  @reload = "getData"/>
  <body-form slot="Body" :data="tableData" :loading="loading" @reload="getData"/>
    <div class="foot" slot="Footer">
      <el-pagination layout="total, prev, pager, next, jumper,sizes"
                     :current-change="pageForm.page"
                     :pase-size="pageForm.pageSize"
                     :page-sizes="[15,30,50,100]"
                     :total="total"
                     @current-change="handleChange"
                     @size-change="handleSizeChange"
                     size="mini"
                     background/>
    </div>
</Layout>
</template>

<script>
import Layout from "@/layout/components/Layout";
import funList from './component/funList';
import bodyForm from './component/bodyForm'
import {getUserList,selectName} from "@/api/user";
export default {
  name: "index",
  components: {Layout,funList,bodyForm},
  data(){
    return {
      loading:false,//表格加载图标
      total:100,//总计
      pageForm:{
        name:'',//名称
        page:1,//页码
        pageSize:15,//每页显示数量
      },
      tableData:[],//从服务器拉取的数据
    }
  },
  methods:{
    /**
     * 改变页码
     * */
    /**
     * 改变页码大小
     * */
    handleChange(e){
      this.pageForm.page = e
      this.getData()
    },
    handleSizeChange(e){
      this.pageForm.pageSize = e
      this.getData()
    },
    test(){
      console.log('test')
    },
    /**
     * 查询用户名称
     * */
    async select(obj){
      this.tableData = []
      if(obj === ''){
        this.getData(this.pageForm)
      }else{
        this.pageForm.name = obj
        this.loading = true
        const res = await selectName(this.pageForm)
        if(res.meta.code === 100){
          this.tableData = res.data.content
          this.total = res.data.totalElements
          this.loading = false
          return this.$message.success(res.meta.msg)
        }
        this.loading = false
        return this.$message.error(res.meta.msg)
      }
    },
    /**
     * 获取所有用户数据
     * @param obj
     * @returns {Promise<void>}
     */
    async getData(){
      this.loading = true
      const res = await getUserList(this.pageForm)
      this.tableData = res.data.content
      this.total = res.data.totalElements
      this.loading = false
    },
  },
  mounted() {
    this.getData()
  }
}

</script>

<style scoped lang="scss">
.foot{
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  background-color: white;
}
::v-deep{
  .el-table__body-wrapper{
    height: calc(100% - 50px);
  }
}
</style>

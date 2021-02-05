<template>
<Layout>
    <fun-list slot="Header"></fun-list>
  <body-form slot="Body" :data="serveData" :loading="loading" />
    <div class="foot" slot="Footer">
      <el-pagination layout="total, prev, pager, next, jumper,sizes"
                     :current-change="upForm.page"
                     :pase-size="upForm.pageSize"
                     :page-sizes="[15,30,50,100]"
                     :total="total"
                     @current-change="handleChange"
                     size="mini"
                     background/>
    </div>
</Layout>
</template>

<script>
import Layout from "@/layout/components/Layout";
import funList from './component/funList';
import bodyForm from './component/bodyForm'
export default {
  name: "index",
  components: {Layout,funList,bodyForm},
  data(){
    return {
      loading:false,//表格加载图标
      total:100,//总计
      upForm:{
        page:1,//页码
        pageSize:15,//每页显示数量

      },
      serveData:[],//从服务器拉取的数据
    }
  },
  methods:{
    handleChange(e){
      console.log(e)
    }
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

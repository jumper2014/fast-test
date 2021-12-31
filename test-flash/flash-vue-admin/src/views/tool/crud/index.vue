<template>
  <div class="app-container">  

    <el-row  :gutter="20">
        <el-col :span="4">
          <el-input v-model="listQuery.flowId" size="mini" placeholder="请输入流程ID"></el-input>
        </el-col>
        <el-col :span="4">
          <el-input v-model="listQuery.flowDesc" size="mini" placeholder="请输入流程名"></el-input>
        </el-col>
       
        
        <el-col :span="4">
          <el-button type="success" size="mini" icon="el-icon-search" @click.native="search">{{ $t('button.search') }}</el-button>
          <el-button type="primary" size="mini" icon="el-icon-refresh" @click.native="reset">{{ $t('button.reset') }}</el-button>
        </el-col>
      </el-row> 

       <br>
      <el-row>
        <el-col :span="24">
          <el-button type="success" size="mini" icon="el-icon-plus" @click.native="add" >
            {{$t('button.add') }}
          </el-button>
        </el-col>
      </el-row>

    <el-row>

      <el-col :span="20">
        <el-table :data="list" v-loading="listLoading" element-loading-text="Loading" border fit highlight-current-row
    @current-change="handleCurrentChange">

      <el-table-column label="流程ID">
        <template slot-scope="scope">
          {{scope.row.flowId}}
        </template>
      </el-table-column>
      <el-table-column label="流程名称">
        <template slot-scope="scope">
          {{scope.row.flowDesc}}
        </template>
      </el-table-column> 
      <el-table-column label="步骤数">
        <template slot-scope="scope">
          {{scope.row.stepCount}}
        </template>
      </el-table-column> 
      <el-table-column label="状态">
        <template slot-scope="scope">
          {{scope.row.flowStatus}}
        </template>
      </el-table-column>

      <el-table-column label="默认结果">
        <template slot-scope="scope">
          {{scope.row.defaultResult}}
        </template>
      </el-table-column>  

   <el-table-column label="操作" min-width="150px">
        <template slot-scope="scope">
          <el-button type="text" size="mini" icon="el-icon-edit" @click.native="editItem(scope.row)" >
            {{$t('button.edit') }}
          </el-button>
          <el-button type="text" size="mini" icon="el-icon-delete" @click.native="removeItem(scope.row)" >
            {{$t('button.delete') }}
          </el-button>
         
        </template>
      </el-table-column>

    </el-table>

        <el-pagination
      background
      layout="total, sizes, prev, pager, next, jumper"
      :page-sizes="[10, 20, 50, 100,500]"
      :page-size="listQuery.limit"
      :total="total"
      :current-page.sync="listQuery.page"
      @size-change="changeSize"
      @current-change="fetchPage"
      @prev-click="fetchPrev"
      @next-click="fetchNext">
    </el-pagination>

      </el-col>
    </el-row>   

<el-dialog
      :title="formTitle"
      :visible.sync="formVisible"
      width="70%">
      <el-form ref="form" :model="form" :rules="rules" label-width="120px" label-position="right">
        <el-row>
          <el-col :span="12">
            <el-form-item label="流程ID" prop="flowId">
              <el-input v-model="form.flowId" minlength=1></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="流程名" prop="flowDesc">
              <el-input v-model="form.flowDesc"  minlength=1></el-input>
            </el-form-item>
          </el-col>

          
          <el-col :span="12">
            <el-form-item label="bizSysId" prop="bizSysId">
              <el-input v-model="form.bizSysId"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="bizType" prop="bizType">
              <el-input v-model="form.bizType"></el-input>
            </el-form-item>
          </el-col>
          
        </el-row>
        <el-form-item>
          <el-button type="primary" @click="saveFlow">{{ $t('button.submit') }}</el-button>
          <el-button @click.native="formVisible = false">{{ $t('button.cancel') }}</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>


    
  </div>
</template>

<script src="./crud.js"></script>
<style rel="stylesheet/scss" lang="scss" scoped>
  @import "src/styles/common.scss";
</style>


<template>
  <div style="top: 100px; width: 600px" class="app-container">
    <el-form :model="form" label-width="120px">
      <el-form-item>
        <el-upload
          class="upload-demo"
          :action="uploadUrl"
          :before-upload="handleBeforeUpload"
          :on-error="handleUploadError"
          :before-remove="beforeRemove"
          multiple
          :limit="5"
          :on-exceed="handleExceed"
          :on-success="handleSuccess"
          :file-list="fileList"
        >
          <el-button size="small" type="primary">选择本地文件</el-button>
          <!-- <div slot="tip" class="el-upload__tip">大小不超过5Mb</div> -->
        </el-upload>
      </el-form-item>
    </el-form>
  </div>
</template>


<script src="./uploadfile.js"></script>
<style rel="stylesheet/scss" lang="scss" scoped>
@import "src/styles/common.scss";
</style>


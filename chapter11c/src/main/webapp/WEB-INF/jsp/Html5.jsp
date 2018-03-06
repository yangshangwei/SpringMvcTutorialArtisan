<!DOCTYPE HTML>
<html>
<head>
<script>
    var totalFileLength, totalUploaded, fileCount, filesUploaded;
	
    //输出调试信息
    function debug(s) { 
        var debug = document.getElementById('debug');
        if (debug) {
            debug.innerHTML = debug.innerHTML + '<br/>' + s;
        }
    }
	
    //当一个文件上传完成，紧接着开始调用下次upLoadNext();
    function onUploadComplete(e) {
        totalUploaded += document.getElementById('files').
                files[filesUploaded].size;
        filesUploaded++;
        debug('complete ' + filesUploaded + " of " + fileCount);
        debug('totalUploaded: ' + totalUploaded);        
        if (filesUploaded < fileCount) {
            uploadNext();
        } else {
            var bar = document.getElementById('bar');
            bar.style.width = '100%';
            bar.innerHTML = '100% complete';
            alert('Finished uploading file(s)');
        }
    }
    
    //当选择的文件发生改变时，重新获取并打印现在所选的文件信息
    function onFileSelect(e) {
        var files = e.target.files; // FileList object
        var output = [];
        fileCount = files.length;
        totalFileLength = 0;
        for (var i=0; i<fileCount; i++) {
            var file = files[i];
            output.push(file.name, ' (',
                  file.size, ' bytes, ',
                  file.lastModifiedDate.toLocaleDateString(), ')'
            );
            output.push('<br/>');
            debug('add ' + file.size);
            totalFileLength += file.size;
        }
        document.getElementById('selectedFiles').innerHTML = 
            output.join('');
        debug('totalFileLength:' + totalFileLength);
    }
	
   //当进度发生改变时，改变进度条
    function onUploadProgress(e) {
        if (e.lengthComputable) {
            var percentComplete = parseInt(
                    (e.loaded + totalUploaded) * 100 
                    / totalFileLength);
            var bar = document.getElementById('bar');
            bar.style.width = percentComplete + '%';
            bar.innerHTML = percentComplete + ' % complete';
        } else {
            debug('unable to compute');
        }
    }

    function onUploadFailed(e) {
        alert("Error uploading file");
    }
    
    
    //将XMLHttpRequest对象的progress事件添加到onLoadProgress并将load事件和error事件分别绑定到对应方法。
    function uploadNext() {
        var xhr = new XMLHttpRequest();
        var fd = new FormData();
        var file = document.getElementById('files').
                files[filesUploaded];
        fd.append("multipartFile", file);
        xhr.upload.addEventListener(
                "progress", onUploadProgress, false);
        xhr.addEventListener("load", onUploadComplete, false);
        xhr.addEventListener("error", onUploadFailed, false);
        xhr.open("POST", "file_upload");
        debug('uploading ' + file.name);
        xhr.send(fd);
    }
	
   //当用户点击提交以后开始执行
    function startUpload() {
        totalUploaded = filesUploaded = 0;
        uploadNext();
    }
    window.onload = function() {
        document.getElementById('files').addEventListener(
                'change', onFileSelect, false);
        document.getElementById('uploadButton').
                addEventListener('click', startUpload, false);
    }
</script>
</head>
<body>
<h1>Multiple file uploads with progress bar</h1>
<div id='progressBar' style='height:20px;border:2px solid green'>
    <div id='bar' 
            style='height:100%;background:#33dd33;width:0%'>
    </div>
</div>
<form>
    <input type="file" id="files" multiple/>
    <br/>
    <output id="selectedFiles"></output>
    <input id="uploadButton" type="button" value="Upload"/>
</form>
<div id='debug' 
    style='height:100px;border:2px solid green;overflow:auto'>
</div>
</body>
</html>
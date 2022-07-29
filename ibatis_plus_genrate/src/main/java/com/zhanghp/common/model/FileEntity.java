package com.zhanghp.common.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @author: zhanghp
 * @date: 2022-07-04 16:09
 */
@Data
public class FileEntity {

    @TableField("relation_id")
    private Long relationId;

    @TableField("file_name")
    private String fileName;

    @TableField("file_path")
    private String filePath;

    public FileEntity() {
    }

    public FileEntity(Long relationId, String fileName, String filePath) {
        this.relationId = relationId;
        this.fileName = fileName;
        this.filePath = filePath;
    }

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}

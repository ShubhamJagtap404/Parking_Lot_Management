package models;

import java.util.Date;

public abstract class BaseModel {
    private Long id;
    private Date createAt;
    private Date updateAt;

//    public BaseModel(long id, Date createAt, Date updateAt) {
//        this.id = id;
//        this.createAt = createAt;
//        this.updateAt = updateAt;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}

package com.example.mypanda.entieny;

import java.util.List;

/**
 * Created by 红超 on 2017/3/17.
 */

public class YuLeTitle {

    /**
     * errno : 0
     * errmsg :
     * data : [{"ename":"xingyan","cname":"熊猫星颜","status":"1","ext":"500","img":"http://i6.pdim.gs/43687aaa7ddc3a78ba116295d4fbd3bd.jpg"},{"cname":"熊猫星秀","ename":"yzdr","img":"http://i8.pdim.gs/89140c5ca93cf55b46dc6331210a4e37.jpeg","ext":"1001","status":"1","extra":"{\"icon\":\"\"}"},{"cname":"户外直播","ename":"hwzb","img":"http://i5.pdim.gs/3a8bb81ff10136dc5270ad23c2a4e64c.png","ext":"1750","status":"1","extra":""},{"cname":"音乐","ename":"music","img":"http://i7.pdim.gs/8e9344e30158d1c220edf0b283ea126d.jpeg","ext":"7990","status":"1","extra":""},{"cname":"萌宠乐园","ename":"pets","img":"http://i9.pdim.gs/f4f6afc39926a3a27ca6fd1c65915f66.jpeg","ext":"8003","status":"1","extra":""},{"cname":"狼人杀","ename":"langrensha","img":"http://i5.pdim.gs/2c715bf4be2be4391f18fe3239d37221.jpeg","ext":"8222","status":"1","extra":"{\"icon\":\"\"}"},{"cname":"影评专区","ename":"cartoon","img":"http://i5.pdim.gs/18f3883d414c0c79476936e0a24fba3b.png","ext":"15000","status":"1","extra":""},{"cname":"科技教育","ename":"technology","img":"http://i9.pdim.gs/c229fe2fca95b936a69ad4afb1db9982.png","ext":"17000","status":"1","extra":""},{"cname":"金融理财","ename":"finance","img":"http://i8.pdim.gs/786e07efa4ac229a043cf37e6c925dfd.png","ext":"18000","status":"1","extra":""}]
     * authseq :
     */

    private int errno;
    private String errmsg;
    private String authseq;
    private List<DataBean> data;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getAuthseq() {
        return authseq;
    }

    public void setAuthseq(String authseq) {
        this.authseq = authseq;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * ename : xingyan
         * cname : 熊猫星颜
         * status : 1
         * ext : 500
         * img : http://i6.pdim.gs/43687aaa7ddc3a78ba116295d4fbd3bd.jpg
         * extra : {"icon":""}
         */

        private String ename;
        private String cname;
        private String status;
        private String ext;
        private String img;
        private String extra;

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public String getCname() {
            return cname;
        }

        public void setCname(String cname) {
            this.cname = cname;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getExt() {
            return ext;
        }

        public void setExt(String ext) {
            this.ext = ext;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getExtra() {
            return extra;
        }

        public void setExtra(String extra) {
            this.extra = extra;
        }
    }
}

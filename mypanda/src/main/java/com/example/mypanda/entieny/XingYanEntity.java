package com.example.mypanda.entieny;

import java.util.List;

/**
 * Created by 红超 on 2017/3/5.
 */

public class XingYanEntity {


    /**
     * errno : 0
     * errmsg :
     * data : {"items":[{"xid":"4549108","rid":"72965760","style_type":"301","display_type":"2","playstatus":"1","name":"认真唱歌","photo":"https://image.xingyan.panda.tv/985418730537c5cf397719567c82f42d.jpeg?x-oss-process=image/quality,q_70","s_photo":"https://image.xingyan.panda.tv/985418730537c5cf397719567c82f42d.jpeg?x-oss-process=image/resize,w_480/quality,q_70","personnum":"6449","province":"北京市","city":"北京市","streamurl":"http://flv-live-qn.xingyan.panda.tv/panda-xingyan/be306ad1232edf6557e1a82d31b04fe6.flv","nickName":"好声音小范范","avatar":"http://i7.pdim.gs/485f73011771e5b0e94c77c0da8b1aaf.jpg","level":"8","levelicon":"anchor8"},{"xid":"1122716","rid":"61726400","style_type":"301","display_type":"2","playstatus":"1","name":"来呀","photo":"https://image.xingyan.panda.tv/78d923d99fab1aea5d8ee4f23c3ff2ca.jpeg?x-oss-process=image/quality,q_70","s_photo":"https://image.xingyan.panda.tv/78d923d99fab1aea5d8ee4f23c3ff2ca.jpeg?x-oss-process=image/resize,w_480/quality,q_70","personnum":"2019","province":"","city":"","streamurl":"http://flv-live-qn.xingyan.panda.tv/panda-xingyan/2daf06eded9d0b7b06bcfea1faef7d15.flv","nickName":"夭夭er","avatar":"http://i9.pdim.gs/c7e92fb8b8ca81f7da336f56fa538297.jpg","level":"5","levelicon":"anchor5"},{"xid":"1124025","rid":"58265988","style_type":"301","display_type":"2","playstatus":"1","name":"熊猫夜话电台","photo":"https://image.xingyan.panda.tv/156798213ffcb676b218bb4ce2f57396.jpeg?x-oss-process=image/quality,q_70","s_photo":"https://image.xingyan.panda.tv/156798213ffcb676b218bb4ce2f57396.jpeg?x-oss-process=image/resize,w_480/quality,q_70","personnum":"12798","province":"","city":"","streamurl":"http://flv-live-qn-zl.xingyan.panda.tv/panda-xingyan/54740b8e15807161d0b9090403db9aac.flv","nickName":"美女直播电台","avatar":"http://i6.pdim.gs/e2eb09a99bc2e0c79e09da78aae4e0ee.jpg","level":"10","levelicon":"anchor10"},{"xid":"1122796","rid":"61764484","style_type":"301","display_type":"2","playstatus":"1","name":"章鱼乖乖","photo":"https://image.xingyan.panda.tv/b8a5843e37f6f15258a920322a7c868e.jpeg?x-oss-process=image/quality,q_70","s_photo":"https://image.xingyan.panda.tv/b8a5843e37f6f15258a920322a7c868e.jpeg?x-oss-process=image/resize,w_480/quality,q_70","personnum":"15072","province":"四川省","city":"成都市","streamurl":"http://flv-live-qn.xingyan.panda.tv/panda-xingyan/2604696712a569be266aaee5c7288992.flv","nickName":"章鱼乖乖乖","avatar":"http://i6.pdim.gs/8e453089cab0af1600d7e3cc27e34441.jpg","level":"10","levelicon":"anchor10"}],"total":148,"place":"2","ename":"xingyan","cname":"熊猫星颜","icon":"https://image.xingyan.panda.tv/c9d21eed1c6b0557e24fe2c89a2ec751.png"}
     */

    private int errno;
    private String errmsg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * items : [{"xid":"4549108","rid":"72965760","style_type":"301","display_type":"2","playstatus":"1","name":"认真唱歌","photo":"https://image.xingyan.panda.tv/985418730537c5cf397719567c82f42d.jpeg?x-oss-process=image/quality,q_70","s_photo":"https://image.xingyan.panda.tv/985418730537c5cf397719567c82f42d.jpeg?x-oss-process=image/resize,w_480/quality,q_70","personnum":"6449","province":"北京市","city":"北京市","streamurl":"http://flv-live-qn.xingyan.panda.tv/panda-xingyan/be306ad1232edf6557e1a82d31b04fe6.flv","nickName":"好声音小范范","avatar":"http://i7.pdim.gs/485f73011771e5b0e94c77c0da8b1aaf.jpg","level":"8","levelicon":"anchor8"},{"xid":"1122716","rid":"61726400","style_type":"301","display_type":"2","playstatus":"1","name":"来呀","photo":"https://image.xingyan.panda.tv/78d923d99fab1aea5d8ee4f23c3ff2ca.jpeg?x-oss-process=image/quality,q_70","s_photo":"https://image.xingyan.panda.tv/78d923d99fab1aea5d8ee4f23c3ff2ca.jpeg?x-oss-process=image/resize,w_480/quality,q_70","personnum":"2019","province":"","city":"","streamurl":"http://flv-live-qn.xingyan.panda.tv/panda-xingyan/2daf06eded9d0b7b06bcfea1faef7d15.flv","nickName":"夭夭er","avatar":"http://i9.pdim.gs/c7e92fb8b8ca81f7da336f56fa538297.jpg","level":"5","levelicon":"anchor5"},{"xid":"1124025","rid":"58265988","style_type":"301","display_type":"2","playstatus":"1","name":"熊猫夜话电台","photo":"https://image.xingyan.panda.tv/156798213ffcb676b218bb4ce2f57396.jpeg?x-oss-process=image/quality,q_70","s_photo":"https://image.xingyan.panda.tv/156798213ffcb676b218bb4ce2f57396.jpeg?x-oss-process=image/resize,w_480/quality,q_70","personnum":"12798","province":"","city":"","streamurl":"http://flv-live-qn-zl.xingyan.panda.tv/panda-xingyan/54740b8e15807161d0b9090403db9aac.flv","nickName":"美女直播电台","avatar":"http://i6.pdim.gs/e2eb09a99bc2e0c79e09da78aae4e0ee.jpg","level":"10","levelicon":"anchor10"},{"xid":"1122796","rid":"61764484","style_type":"301","display_type":"2","playstatus":"1","name":"章鱼乖乖","photo":"https://image.xingyan.panda.tv/b8a5843e37f6f15258a920322a7c868e.jpeg?x-oss-process=image/quality,q_70","s_photo":"https://image.xingyan.panda.tv/b8a5843e37f6f15258a920322a7c868e.jpeg?x-oss-process=image/resize,w_480/quality,q_70","personnum":"15072","province":"四川省","city":"成都市","streamurl":"http://flv-live-qn.xingyan.panda.tv/panda-xingyan/2604696712a569be266aaee5c7288992.flv","nickName":"章鱼乖乖乖","avatar":"http://i6.pdim.gs/8e453089cab0af1600d7e3cc27e34441.jpg","level":"10","levelicon":"anchor10"}]
         * total : 148
         * place : 2
         * ename : xingyan
         * cname : 熊猫星颜
         * icon : https://image.xingyan.panda.tv/c9d21eed1c6b0557e24fe2c89a2ec751.png
         */

        private int total;
        private String place;
        private String ename;
        private String cname;
        private String icon;
        private List<ItemsBean> items;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public String getPlace() {
            return place;
        }

        public void setPlace(String place) {
            this.place = place;
        }

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

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * xid : 4549108
             * rid : 72965760
             * style_type : 301
             * display_type : 2
             * playstatus : 1
             * name : 认真唱歌
             * photo : https://image.xingyan.panda.tv/985418730537c5cf397719567c82f42d.jpeg?x-oss-process=image/quality,q_70
             * s_photo : https://image.xingyan.panda.tv/985418730537c5cf397719567c82f42d.jpeg?x-oss-process=image/resize,w_480/quality,q_70
             * personnum : 6449
             * province : 北京市
             * city : 北京市
             * streamurl : http://flv-live-qn.xingyan.panda.tv/panda-xingyan/be306ad1232edf6557e1a82d31b04fe6.flv
             * nickName : 好声音小范范
             * avatar : http://i7.pdim.gs/485f73011771e5b0e94c77c0da8b1aaf.jpg
             * level : 8
             * levelicon : anchor8
             */

            private String xid;
            private String rid;
            private String style_type;
            private String display_type;
            private String playstatus;
            private String name;
            private String photo;
            private String s_photo;
            private String personnum;
            private String province;
            private String city;
            private String streamurl;
            private String nickName;
            private String avatar;
            private String level;
            private String levelicon;

            public String getXid() {
                return xid;
            }

            public void setXid(String xid) {
                this.xid = xid;
            }

            public String getRid() {
                return rid;
            }

            public void setRid(String rid) {
                this.rid = rid;
            }

            public String getStyle_type() {
                return style_type;
            }

            public void setStyle_type(String style_type) {
                this.style_type = style_type;
            }

            public String getDisplay_type() {
                return display_type;
            }

            public void setDisplay_type(String display_type) {
                this.display_type = display_type;
            }

            public String getPlaystatus() {
                return playstatus;
            }

            public void setPlaystatus(String playstatus) {
                this.playstatus = playstatus;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getS_photo() {
                return s_photo;
            }

            public void setS_photo(String s_photo) {
                this.s_photo = s_photo;
            }

            public String getPersonnum() {
                return personnum;
            }

            public void setPersonnum(String personnum) {
                this.personnum = personnum;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getStreamurl() {
                return streamurl;
            }

            public void setStreamurl(String streamurl) {
                this.streamurl = streamurl;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public String getLevelicon() {
                return levelicon;
            }

            public void setLevelicon(String levelicon) {
                this.levelicon = levelicon;
            }
        }
    }
}

package com.example.mypanda.entieny;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/**
 * Created by 红超 on 2017/2/18.
 */
public class AllTitle implements Parcelable {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllTitle allTitle = (AllTitle) o;
        if (errno != allTitle.errno) return false;
        if (authseq != null ? !authseq.equals(allTitle.authseq) : allTitle.authseq != null)
            return false;
        if (errmsg != null ? !errmsg.equals(allTitle.errmsg) : allTitle.errmsg != null)
            return false;
        return data != null ? data.equals(allTitle.data) : allTitle.data == null;
    }

    @Override
    public int hashCode() {
        int result = authseq != null ? authseq.hashCode() : 0;
        result = 31 * result + (errmsg != null ? errmsg.hashCode() : 0);
        result = 31 * result + errno;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    /**
     * authseq :
     * data : [{"cdn_rate":"0","cname":"英雄联盟","ename":"lol","ext":"1000","img":"http://i9.pdim.gs/23e529ba353b33c2f70e6d60f6be4c29.jpeg","status":"1"},{"cdn_rate":"0","cname":"守望先锋","ename":"overwatch","ext":"1500","img":"http://i8.pdim.gs/70eb88bf67257964e012eacc97263f9f.png","status":"1"},{"cdn_rate":"0","cname":"炉石传说","ename":"hearthstone","ext":"2000","img":"http://i6.pdim.gs/18a15f74900b717ef5b77283ec8e0c37.png","status":"1"},{"cdn_rate":"0","cname":"主机游戏","ename":"zhuji","ext":"2980","img":"http://i7.pdim.gs/dedb172888351d04c6256e60f88f0c23.png","status":"1"},{"cdn_rate":"0","cname":"黎明杀机","ename":"deadbydaylight","ext":"2990","img":"http://i9.pdim.gs/ac9bfe540a489745c4f6334725ffa3d3.jpeg","status":"1"},{"cdn_rate":"0","cname":"饥荒","ename":"starve","ext":"3000","img":"http://i9.pdim.gs/962213bce2da73643f4dd3407ce183cf.jpeg","status":"1"},{"cdn_rate":"0","cname":"DOTA2","ename":"dota2","ext":"3001","img":"http://i5.pdim.gs/4795f1e933be01c4e7055e157c58aca0.png","status":"1"},{"cdn_rate":"0","cname":"H1Z1","ename":"h1z1","ext":"3013","img":"http://i8.pdim.gs/ef433db1e3994e882d5168dd7b99cc82.jpeg","status":"1"},{"cdn_rate":"0","cname":"魔兽DOTA1","ename":"war3","ext":"3250","img":"http://i7.pdim.gs/2c0e9577b5e15e8d5393aaf9c7956d08.jpeg","status":"1"},{"cdn_rate":"0","cname":"DNF","ename":"dnf","ext":"3499","img":"http://i7.pdim.gs/047467e36ad7fea589f987f5992638c8.png","status":"1"},{"cdn_rate":"0","cname":"穿越火线","ename":"cf","ext":"3500","img":"http://i7.pdim.gs/6d15c0f3da8914a30b27105670e6d62a.png","status":"1"},{"cdn_rate":"0","cname":"魔兽世界","ename":"wow","ext":"3500","img":"http://i5.pdim.gs/2d898309847b42f51e65e91c67596640.png","status":"1"},{"cdn_rate":"0","cname":"CS:GO","ename":"csgo","ext":"3656","img":"http://i7.pdim.gs/95748e44de319d47d7ebdf817928218d.png","status":"1"},{"cdn_rate":"0","cname":"暗黑破坏神3","ename":"diablo3","ext":"3665","img":"http://i9.pdim.gs/2f5967bf2d64cf9a864eb1088fc4e6b9.png","status":"1"},{"cdn_rate":"0","cname":"风暴英雄","ename":"heroes","ext":"3676","img":"http://i9.pdim.gs/c21e0383b1d324c4d3a55f01c0785a7e.png","status":"1"},{"cdn_rate":"0","cname":"体育竞技","ename":"spg","ext":"4025","img":"http://i5.pdim.gs/2f86239213ce4b00a78d2e5cf7295213.png","status":"1"},{"cdn_rate":"0","cname":"我的世界","ename":"mc","ext":"4030","img":"http://i9.pdim.gs/8deff4e452c6908621518321f6d944e3.png","status":"1"},{"cdn_rate":"0","cname":"格斗游戏","ename":"ftg","ext":"4050","img":"http://i5.pdim.gs/25b34e7976346010c855d65cf3b37ec9.png","status":"1"},{"cdn_rate":"0","cname":"拳皇97","ename":"kof97","ext":"4060","img":"http://i9.pdim.gs/12a9ecf556ff79fa81f78e588f7c5b3d.jpeg","status":"1"},{"cdn_rate":"0","cname":"剑网3","ename":"jxol3","ext":"4490","img":"http://i9.pdim.gs/905d8ccbd434a89adf404371ada5e929.jpeg","status":"1"},{"cdn_rate":"0","cname":"天涯明月刀","ename":"tymyd","ext":"4492","img":"http://i7.pdim.gs/22fb119d8c3e3917e1927ffdc0d54d37.png","status":"1"},{"cdn_rate":"0","cname":"跑跑卡丁车","ename":"popkart","ext":"4493","img":"http://i9.pdim.gs/595edb56afb784254121f499c594931c.jpeg","status":"1"},{"cdn_rate":"0","cname":"传奇专区","ename":"legends","ext":"4494","img":"http://i7.pdim.gs/08293e337689b44a7df632379d292ace.png","status":"1"},{"cdn_rate":"0","cname":"怀旧经典","ename":"hjjd","ext":"5018","img":"http://i8.pdim.gs/deacbc1bcecbf2494a75efa6d699f031.png","status":"1"},{"cdn_rate":"0","cname":"精灵宝可梦","ename":"pokemon","ext":"5030","img":"http://i6.pdim.gs/848d3abc94e97c6fd3c9f3438090aabf.jpeg","status":"1"},{"cdn_rate":"0","cname":"流放之路","ename":"liufang","ext":"5057","img":"http://i8.pdim.gs/bda2f1151e1a9730ac566e07db4c59ac.jpeg","status":"1"},{"cdn_rate":"0","cname":"星际争霸2","ename":"starcraft","ext":"5058","img":"http://i8.pdim.gs/bac22be920ca30206eb1a2037913e5a6.png","status":"1"},{"cdn_rate":"0","cname":"网络游戏","ename":"wy","ext":"5080","img":"http://i5.pdim.gs/e8b33c809f23d6bd767be39a4e9c60cd.jpeg","status":"1"},{"cdn_rate":"0","cname":"战争游戏","ename":"shoot","ext":"8000","img":"http://i7.pdim.gs/08b4c3d4eaf326f2cbb1c950b3c17adb.png","status":"1"},{"cdn_rate":"0","cname":"王者荣耀","ename":"kingglory","ext":"8010","img":"http://i6.pdim.gs/1288f555f436bbc11a4146e032a5ad4e.png","status":"1"},{"cdn_rate":"0","cname":"仙境传说","ename":"ro","ext":"8012","img":"http://i7.pdim.gs/b2db901f3337874b65f10e1606eaf769.jpeg","status":"1"},{"cdn_rate":"0","cname":"阴阳师","ename":"yys","ext":"8014","img":"http://i9.pdim.gs/1023198bb0c44b63e06f0ba80dd9ba5e.jpeg","status":"1"},{"cdn_rate":"0","cname":"综合手游","ename":"mobilegame","ext":"8015","img":"http://i6.pdim.gs/456901c1312c739e5f8802d95671be64.jpeg","status":"1"},{"cdn_rate":"0","cname":"捕鱼天地","ename":"fishes","ext":"8018","img":"http://i8.pdim.gs/a527d2849b207e822a86778ab72d3741.jpeg","status":"1"},{"cdn_rate":"0","cname":"皇室战争","ename":"clashroyale","ext":"8020","img":"http://i1.pdim.gs/t01dcf76a6f30fe40c9.jpg","status":"1"},{"cdn_rate":"0","cname":"棋牌游戏","ename":"qipai","ext":"8500","img":"http://i9.pdim.gs/7172f8f1093ab31311f0c92d21031618.png","status":"1"}]
     * errmsg :
     * errno : 0
     */

    private String authseq;
    private String errmsg;
    private int errno;
    private List<DataBean> data;
    protected AllTitle(Parcel in) {
        authseq = in.readString();
        errmsg = in.readString();
        errno = in.readInt();
    }
    public static final Creator<AllTitle> CREATOR = new Creator<AllTitle>() {
        @Override
        public AllTitle createFromParcel(Parcel in) {
            return new AllTitle(in);
        }
        @Override
        public AllTitle[] newArray(int size) {
            return new AllTitle[size];
        }
    };
    public String getAuthseq() {
        return authseq;
    }
    public void setAuthseq(String authseq) {
        this.authseq = authseq;
    }
    public String getErrmsg() {
        return errmsg;
    }
    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
    public int getErrno() {
        return errno;
    }
    public void setErrno(int errno) {
        this.errno = errno;
    }
    public List<DataBean> getData() {
        return data;
    }
    public void setData(List<DataBean> data) {
        this.data = data;
    }
    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(authseq);
        dest.writeString(errmsg);
        dest.writeInt(errno);
    }
    public static class DataBean implements Parcelable {
        public static Creator<DataBean> getCREATOR() {
            return CREATOR;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DataBean dataBean = (DataBean) o;
            if (cdn_rate != null ? !cdn_rate.equals(dataBean.cdn_rate) : dataBean.cdn_rate != null)
                return false;
            if (cname != null ? !cname.equals(dataBean.cname) : dataBean.cname != null)
                return false;
            if (ename != null ? !ename.equals(dataBean.ename) : dataBean.ename != null)
                return false;
            if (ext != null ? !ext.equals(dataBean.ext) : dataBean.ext != null) return false;
            if (img != null ? !img.equals(dataBean.img) : dataBean.img != null) return false;
            return status != null ? status.equals(dataBean.status) : dataBean.status == null;
        }
        @Override
        public int hashCode() {
            int result = cdn_rate != null ? cdn_rate.hashCode() : 0;
            result = 31 * result + (cname != null ? cname.hashCode() : 0);
            result = 31 * result + (ename != null ? ename.hashCode() : 0);
            result = 31 * result + (ext != null ? ext.hashCode() : 0);
            result = 31 * result + (img != null ? img.hashCode() : 0);
            result = 31 * result + (status != null ? status.hashCode() : 0);
            return result;
        }
        /**
         * cdn_rate : 0
         * cname : 英雄联盟
         * ename : lol
         * ext : 1000
         * img : http://i9.pdim.gs/23e529ba353b33c2f70e6d60f6be4c29.jpeg
         * status : 1
         */
        private String cdn_rate;
        private String cname;
        private String ename;
        private String ext;
        private String img;
        private String status;
        public DataBean(Parcel in) {
            cdn_rate = in.readString();
            cname = in.readString();
            ename = in.readString();
            ext = in.readString();
            img = in.readString();
            status = in.readString();
        }
        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel in) {
                return new DataBean(in);
            }
            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };
        public String getCdn_rate() {
            return cdn_rate;
        }
        public void setCdn_rate(String cdn_rate) {
            this.cdn_rate = cdn_rate;
        }
        public String getCname() {
            return cname;
        }
        public void setCname(String cname) {
            this.cname = cname;
        }
        public String getEname() {
            return ename;
        }
        public void setEname(String ename) {
            this.ename = ename;
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
        public String getStatus() {
            return status;
        }
        public void setStatus(String status) {
            this.status = status;
        }
        @Override
        public int describeContents() {
            return 0;
        }
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(cdn_rate);
            dest.writeString(cname);
            dest.writeString(ename);
            dest.writeString(ext);
            dest.writeString(img);
            dest.writeString(status);
        }
    }
}

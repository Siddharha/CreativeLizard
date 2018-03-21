package in.creativelizard.creativelizard.beans;

import java.util.List;

/**
 * Created by siddhartha on 13/3/18.
 */

public class ProductListOutput {
    /**
     * sucess : true
     * productList : [{"appName":"Creative Notes","appImg":"https://lh3.googleusercontent.com/0u706NuXjGWwTfeBBKAxsaAkDsOoXfcqVHPaTAmz8A2gLw0wolqeTlLcdxq6gl_rwqw=w200","appLink":"https://play.google.com/store/apps/details?id=com.creativelizard.creativenote"},{"appName":"Paint X","appImg":"https://lh3.googleusercontent.com/cuU3I9olUCLZnj6UEdgAs9QbEWGgVNauEMsWMnYB5s2IC6BAqMX7JcMkV-59dCstDw=w200","appLink":"https://play.google.com/store/apps/details?id=in.creativelizard.paintx"},{"appName":"Folders File Manager","appImg":"https://lh3.googleusercontent.com/SWLADJiQTS8W9LzILzJct-W_ycDqC80-brq3GfTj_V6kCoNVNWsAaqeRbWIGkA5CGEA=w200","appLink":"https://play.google.com/store/apps/details?id=in.creativelizard.folders"},{"appName":"Barcode Expert","appImg":"https://lh3.googleusercontent.com/eI9v61GJ1mGCNR01LKb15WLGmMLQZ6mUm2GRe2QipaF59wMStw3JPrfmgjFi4G5j4oI=w200","appLink":"https://play.google.com/store/apps/details?id=in.creativelizard.barcodeexpert"},{"appName":"Binary Clock Widget","appImg":"https://lh3.googleusercontent.com/mfb0bkvMGiL6qmxiDrdaP6mxYJiANQPRdTOXncZxgKAQzTdM7vClwsGA84717NcXAeI=w200","appLink":"https://play.google.com/store/apps/details?id=app1.sid.com.binaryclockwidget"}]
     */

    private boolean sucess;
    private List<ProductListBean> productList;

    public boolean isSucess() {
        return sucess;
    }

    public void setSucess(boolean sucess) {
        this.sucess = sucess;
    }

    public List<ProductListBean> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductListBean> productList) {
        this.productList = productList;
    }

    public static class ProductListBean {
        /**
         * appName : Creative Notes
         * appImg : https://lh3.googleusercontent.com/0u706NuXjGWwTfeBBKAxsaAkDsOoXfcqVHPaTAmz8A2gLw0wolqeTlLcdxq6gl_rwqw=w200
         * appLink : https://play.google.com/store/apps/details?id=com.creativelizard.creativenote
         */

        private String appName;
        private String appImg;
        private String appLink;

        public String getAppName() {
            return appName;
        }

        public void setAppName(String appName) {
            this.appName = appName;
        }

        public String getAppImg() {
            return appImg;
        }

        public void setAppImg(String appImg) {
            this.appImg = appImg;
        }

        public String getAppLink() {
            return appLink;
        }

        public void setAppLink(String appLink) {
            this.appLink = appLink;
        }
    }
}

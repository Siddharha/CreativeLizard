package in.creativelizard.creativelizard.interfaces;

import in.creativelizard.creativelizard.beans.ProductListInput;
import in.creativelizard.creativelizard.beans.ProductListOutput;
import in.creativelizard.creativelizard.util.ConstantClass;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by siddhartha on 13/3/18.
 */

public interface ApiInterface {
    @POST(ConstantClass.GET_PRODUCT_LIST)
    Observable<ProductListOutput> getProductList(@Body ProductListInput productListInput);

}

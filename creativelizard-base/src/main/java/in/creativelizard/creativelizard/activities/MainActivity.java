package in.creativelizard.creativelizard.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import in.creativelizard.creativelizard.R;
import in.creativelizard.creativelizard.adapters.ProductViewAdapter;
import in.creativelizard.creativelizard.beans.ProductItem;
import in.creativelizard.creativelizard.beans.ProductListInput;
import in.creativelizard.creativelizard.beans.ProductListOutput;
import in.creativelizard.creativelizard.interfaces.ApiInterface;
import in.creativelizard.creativelizard.util.ApiClient;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private TextView tvDisplay;
    private ApiInterface apiService;
    private RecyclerView rlItems;
    private ProductViewAdapter productViewAdapter;
    private ArrayList<ProductItem> productListOutputs;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        callGetProductsAPI();
        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();
    }

    private void callGetProductsAPI() {
        final ProductListInput productListInput = new ProductListInput();
        final ProductListInput.DataBean dataBean = new ProductListInput.DataBean();
        dataBean.setAccess_token("Phantom1650763");
        productListInput.setData(dataBean);

        Observable<ProductListOutput> productListOutputObservable = apiService.getProductList(productListInput);
        productListOutputObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ProductListOutput>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ProductListOutput productListOutput) {
                        if(productListOutput.isSucess()){
                            //tvDisplay.setText(productListOutput.getProductList().get(0).getAppName());
                            for(int i=0; i<productListOutput.getProductList().size();i++) {
                                ProductItem productItem = new ProductItem();
                                productItem.setImg(productListOutput.getProductList().get(i).getAppImg());
                                productItem.setName(productListOutput.getProductList().get(i).getAppName());
                                productItem.setLink(productListOutput.getProductList().get(i).getAppLink());

                                productListOutputs.add(productItem);
                            }
                            productViewAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initialize() {
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        productListOutputs = new ArrayList<>();
        tvDisplay = findViewById(R.id.tvDisplay);
        apiService = ApiClient.getClient().create(ApiInterface.class);
        rlItems = findViewById(R.id.rlItems);
        productViewAdapter = new ProductViewAdapter(productListOutputs,R.layout.product_view_cell,this);

        rlItems.setLayoutManager(layoutManager);
        rlItems.setAdapter(productViewAdapter);
    }
}

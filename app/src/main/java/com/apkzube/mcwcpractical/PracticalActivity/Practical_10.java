package com.apkzube.mcwcpractical.PracticalActivity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.apkzube.mcwcpractical.Car;
import com.apkzube.mcwcpractical.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practical_10 extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Car> cars=new ArrayList<>();
    CarAdapter carAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_10);
        allocation();
        setEvent();
    }

    private void allocation() {

        recyclerView=findViewById(R.id.recycleView);
        carAdapter=new CarAdapter(cars);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(carAdapter);

        ArrayList<String> carCompanyList=new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.car_company)));
        ArrayList<String> carModelList=new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.car_model)));
        ArrayList<Integer> imgArrayList=new ArrayList<>();
        //add image accets
        imgArrayList.add(R.mipmap.a);
        imgArrayList.add(R.mipmap.b);
        imgArrayList.add(R.mipmap.c);
        imgArrayList.add(R.mipmap.d);
        imgArrayList.add(R.mipmap.e);
        imgArrayList.add(R.mipmap.f);

        //add launch date
        ArrayList<String> launchDateArrayList=new ArrayList<>();
        launchDateArrayList.add("10 Jan 2017");
        launchDateArrayList.add("13 Oct 2016");
        launchDateArrayList.add("10 Dec 2015");
        launchDateArrayList.add("25 Feb 2017");
        launchDateArrayList.add("07 Jun 2010");
        launchDateArrayList.add("29 Fab 2011");

        //Colors ArrayList
        ArrayList<String> colorArrayList=new ArrayList<>();
        colorArrayList.add("Black,Silver,Red,Blue");
        colorArrayList.add("Black,Silver,White");
        colorArrayList.add("Gray,Silver,Golden");
        colorArrayList.add("Red,Silver,Gray");
        colorArrayList.add("Green,Red,Yellow");
        colorArrayList.add("Gray,Red,Blue");

        Car carObj;
        for(int i=0;i<carCompanyList.size();i++){
            carObj=new Car(carCompanyList.get(i),
                        carModelList.get(i),
                        imgArrayList.get(i),
                        colorArrayList.get(i),
                        launchDateArrayList.get(i));
            cars.add(carObj);
        }

        carAdapter.notifyDataSetChanged();

    }
    private void setEvent() {

    }
    public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder>{

        private List<Car> carList;

        public CarAdapter(List<Car> carList) {
            this.carList = carList;
        }

        @NonNull
        @Override
        public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.car_row,parent,false);

            return new CarViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
            final  Car  myCar=carList.get(position);
            holder.txtCarCompnay.setText(myCar.getCompanyName());
            holder.txtModelName.setText(myCar.getCarModelName());
            holder.imgCar.setImageResource(myCar.getCarImg());
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //next activity :
                    Pair<View, String> pair1 = new Pair<>(findViewById(R.id.imgCar), "img_bt");
                    ActivityOptionsCompat op1 = ActivityOptionsCompat.makeSceneTransitionAnimation(Practical_10.this, pair1);
                    startActivity(new Intent(Practical_10.this,Practical_10_New.class)
                    .putExtra("company",myCar.getCompanyName())
                    .putExtra("model",myCar.getCarModelName())
                    .putExtra("imgId",myCar.getCarImg())
                    .putExtra("colors",myCar.getCarColors())
                    .putExtra("launch_date",myCar.getLaunchDate()),op1.toBundle());
                }
            });
        }

        @Override
        public int getItemCount() {
            return carList.size();
        }

        public class CarViewHolder extends RecyclerView.ViewHolder{
            View mView;
            ImageView imgCar;
            TextView txtCarCompnay,txtModelName;

            public CarViewHolder(View itemView) {
                super(itemView);
                mView=itemView;
                imgCar=mView.findViewById(R.id.imgCar);
                txtCarCompnay=mView.findViewById(R.id.txtCarCompany);
                txtModelName=mView.findViewById(R.id.txtModelName);

            }
        }
    }
}

package com.kaamkaaj.kaamkaaj.serviceProviderActivities;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.kaamkaaj.kaamkaaj.R;
import com.kaamkaaj.kaamkaaj.RegisterAsActivity;
import com.kaamkaaj.kaamkaaj.Service_category;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import static com.kaamkaaj.kaamkaaj.Service_category.Service_cat;


public class RegisterServiceActivity extends AppCompatActivity implements View.OnClickListener {

    Spinner spinner;

// public class RegisterServiceActivity extends AppCompatActivity implements View.OnClickListener {
//    private Button register;
//    private EditText name, email, phone, password, re_password, address, city, charges, cnic;
//    private CircleImageView image;
//    private String bitmapTo64, selectedGender = null;
//    private static String resultPath = null;
//    private final int REQUEST_CODE = 1;
//    private String user_role = "vendor";
//    Misc misc;
//    private ArrayList<String> selectedServices = new ArrayList<>();
//    private ArrayList<Service> allServices = new ArrayList<>();
//    private ArrayAdapter<String> serviceAdapter;
//    private RadioButton male, female;
//    private File uploadFile = null;
//
//    private double lat, lon;
//
//    private GridLayout checkBoxLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_service);
        setTitle("Register As Service");

        spinner=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, Service_cat)

        {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint

                    return false;
                } else {
                    return true;
                }
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);

                } else {
                    tv.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                }
                return view;
            }

        };

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            spinner.setSelection(position);
            TextView tv = (TextView) view;
            tv.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });

        //spinner =findViewById(R.id.spinner);



//        tvSelectCategory=findViewById(R.id.tvSelectCategory);
//
//
//
//        spinner.setAdapter(adapter);
//        tvSelectCategory.setText(Service_category.Service_cat[spinner.getSelectedItemPosition()]);
//       // String x = Service_category.Service_cat[spinner.getSelectedItemPosition()];



//        misc = new Misc(this);
//
//        checkBoxLayout = findViewById(R.id.services);
//
//        name = findViewById(R.id.provider_name);
//        email = findViewById(R.id.provider_register_email);
//        phone = findViewById(R.id.provider_phone);
//        address = findViewById(R.id.provider_address);
//        city = findViewById(R.id.provider_city);
//        re_password = findViewById(R.id.provider_confirm_password);
//        password = findViewById(R.id.provider_password);
//        charges = findViewById(R.id.provider_charges);
//        cnic = findViewById(R.id.reg_cnic);
//
//        male = findViewById(R.id.cus_male);
//        female = findViewById(R.id.cus_female);
//
//        male.setOnClickListener(this);
//        female.setOnClickListener(this);
//
//        if(male.isChecked()) {
//            selectedGender = male.getText().toString();
//        }
//        if(female.isChecked()) {
//            female.getText().toString();
//        }
//
//        image = findViewById(R.id.profile_pic_service);
//        image.setOnClickListener(this);
//
//        register = findViewById(R.id.provider_register_button);
//        register.setOnClickListener(this);
//
//        if(misc.isConnectedToInternet()){
//            fetchServices();
//        }
//        else{
//            misc.showToast("No Internet Connection");
//        }
//    }
//
//    @Override
//    public void onClick(View v) {
//
//        if(v.getId() == male.getId()){
//            if(male.isChecked()){
//                selectedGender = male.getText().toString();
//            }
//        }
//        if(v.getId() == female.getId()){
//            if(female.isChecked()) {
//                selectedGender = female.getText().toString();
//            }
//        }
//
//        if(v.getId() == image.getId()) {
//            ActivityCompat.requestPermissions
//                    (RegisterServiceActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE);
//        }
//
//        if(v.getId() == register.getId()){
//            if(misc.isConnectedToInternet()){
//                registerVendor();
//            }
////            Intent intent = new Intent(this, ServiceHomeActivity.class);
////            startActivity(intent);
////            finish();
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        if(requestCode == REQUEST_CODE){
//            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//                Intent intent = new Intent(Intent.ACTION_PICK);
//                intent.setType("image/*");
//                startActivityForResult(intent, REQUEST_CODE);
//            }
//            else{
//                Toast.makeText(this, "You don't have permissions", Toast.LENGTH_SHORT).show();
//            }
//            return;
//        }
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if(data == null){
//            Toast.makeText(getApplicationContext(), "Please Select Profile Image", Toast.LENGTH_LONG).show();
//            return;
//        }
//
//        Uri selectedImageUri = data.getData( );
//        String picturePath = getPath(getApplicationContext(), selectedImageUri );
//
//        try{
//
//            InputStream inputStream = getContentResolver().openInputStream(selectedImageUri);
//            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
//            bitmapTo64 = bitmapToBase64(bitmap);
//            Log.d("Converted Image", bitmapTo64);
//            image.setImageBitmap(bitmap);
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//        super.onActivityResult(requestCode, resultCode, data);
//    }
//
//    public static String getPath(Context context, Uri uri ) {
//        String[] proj = { MediaStore.Images.Media.DATA };
//        Cursor cursor = context.getContentResolver( ).query( uri, proj, null, null, null );
//        if(cursor != null){
//            if ( cursor.moveToFirst()) {
//                int column_index = cursor.getColumnIndexOrThrow( proj[0] );
//                resultPath = cursor.getString( column_index );
//
//            }
//            cursor.close( );
//        }
//        if(resultPath == null) {
//            resultPath = null;
//        }
//        return resultPath;
//    }
//
//    private String bitmapToBase64(Bitmap bitmap) {
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
//        byte[] byteArray = byteArrayOutputStream .toByteArray();
//        return Base64.encodeToString(byteArray, Base64.DEFAULT);
//    }
//    private void fetchServices(){
//        final ProgressDialog pd = new ProgressDialog(this);
//        pd.setMessage("Loading Services");
//        pd.setCancelable(false);
//        pd.show();
//
//        Ion.with(this)
//                .load(misc.ROOT_PATH+"get_services")
//                .asString()
//                .withResponse()
//                .setCallback(new FutureCallback<Response<String>>() {
//                    @SuppressLint("ResourceAsColor")
//                    @Override
//                    public void onCompleted(Exception e, Response<String> result) {
//                        if(e != null) {
//                            misc.showToast("Please check your connection");
//                            pd.dismiss();
//                            return;
//                        }
//
//                        try {
//                            JSONArray serviceArray = new JSONArray(result.getResult());
//                            if(serviceArray.length() < 1) {
//                                misc.showToast("No Service Found");
//                                pd.dismiss();
//                            }
//                            else{
//                                allServices.clear();
//                                for (int i = 0; i < serviceArray.length(); i++) {
//                                    JSONObject serviceObject = (JSONObject) serviceArray.get(i);
//                                    String serviceName = serviceObject.getString("service_name");
//                                    String serviceId = serviceObject.getString("service_id");
//                                    String serviceImage = serviceObject.getString("service_image");
//                                    allServices.add(new Service(serviceId, serviceName, serviceImage));
//
//                                    final CheckBox cb = new CheckBox(getApplicationContext());
//                                    cb.setText(serviceName.toUpperCase());
//                                    cb.setTextColor(R.color.colorPrimary);
//                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                                        cb.setButtonTintList(ColorStateList.valueOf(R.color.colorPrimary));
//                                    }
//                                    cb.setId(Integer.parseInt(serviceId));
//                                    cb.setTextSize(10);
//                                    cb.setOnClickListener(new View.OnClickListener() {
//                                        @Override
//                                        public void onClick(View v) {
//                                            String selectedItem = String.valueOf(cb.getId());
//                                            if(selectedServices.contains(selectedItem)){
//                                                selectedServices.remove(selectedItem);
//                                            }
//                                            else{
//                                                selectedServices.add(selectedItem);
//                                            }
//                                        }
//                                    });
//
//                                    checkBoxLayout.addView(cb);
//                                    pd.dismiss();
//                                }
//                            }
//                        } catch (JSONException e1) {
//                            e1.printStackTrace();
//                        }
//                    }
//                });
//    }
//
//    private boolean validate(){
//
//        String user_name = name.getText().toString().toLowerCase().trim();
//        String user_email = email.getText().toString().toLowerCase().trim();
//        String user_phone = phone.getText().toString().toLowerCase().trim();
//        String user_password = password.getText().toString();
//        String user_re_password = re_password.getText().toString();
//        String user_address = address.getText().toString();
//        String user_city = city.getText().toString();
//        String user_charges = charges.getText().toString();
//        String user_cnic = cnic.getText().toString();
//        LatLng latLng = misc.getCoordinates(user_address);
//
//        getCoordinates(user_address);
//
//        String regex = "[A-Za-z A-Za-z]+";
//        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
//
//        if(user_name.length() < 3 && !user_name.matches(regex)){
//            misc.showToast("Invalid Name");
//            name.setError("Invalid Name");
//            return false;
//        }
//        if(!user_email.matches(emailPattern) && user_email.isEmpty()) {
//            misc.showToast("Invalid Email");
//            email.setError("Invalid Email");
//            return false;
//        }
//        if(user_phone.length() < 11) {
//            misc.showToast("Invalid Phone Number");
//            phone.setError("Invalid Phone Number");
//            return false;
//        }
//        if(user_password.length() < 6 ) {
//            misc.showToast("Password should be min 6 characters");
//            password.setError("Password should be min 6 characters");
//            return false;
//        }
//        if(!user_password.equals(user_re_password)) {
//            misc.showToast("Password Mismatch");
//            re_password.setError("Password Mismatch");
//            return false;
//        }
//        if(user_city.length() < 3) {
//            misc.showToast("Invalid City");
//            city.setError("Invalid City");
//            return false;
//        }
//        if(user_address.length() < 5) {
//            misc.showToast("Please Enter Full Address");
//            address.setError("Please Enter Full Address");
//            return false;
//        }
//        if(user_charges.isEmpty() || user_charges.length() < 3) {
//            misc.showToast("Charges must be Min Rs 100");
//            address.setError("Charges must be Min Rs 100");
//            return false;
//        }
//        if(user_cnic.length() < 13) {
//            misc.showToast("Invalid CNIC");
//            cnic.setError("Invalid CNIC");
//            return false;
//        }
//        if(latLng == null) {
//            misc.showToast("Service Location Not Found");
//            return false;
//        }
//        if(selectedServices.size() < 1) {
//            misc.showToast("Please select atleast one service");
//            return false;
//        }
//
//        if(selectedServices.size() > 5) {
//            misc.showToast("You can select maximum 5 services");
//            return false;
//        }
//
//        return true;
//    }
//
//    private void registerVendor(){
//        if(validate()) {
//            if(resultPath != null) {
//                uploadFile = new File(resultPath);
//                registerWithImage();
//            }
//            else{
//                registerWithoutImage();
//            }
//        }
//    }
//
//    private void registerWithImage(){
//        final ProgressDialog pd = new ProgressDialog(this);
//        pd.setMessage("Registration in process...");
//        pd.setCancelable(false);
//        pd.show();
//
//
//        String items = "";
//        for(String item : selectedServices){
//            items += item+",";
//        }
//
//        Ion.with(this)
//                .load(misc.ROOT_PATH+"create_user")
//                .setMultipartFile("user_image", uploadFile)
//                .setMultipartParameter("user_name", name.getText().toString().trim())
//                .setMultipartParameter("user_email", email.getText().toString().trim())
//                .setMultipartParameter("user_phone", phone.getText().toString().trim())
//                .setMultipartParameter("user_cnic", cnic.getText().toString().trim())
//                .setMultipartParameter("user_password", password.getText().toString())
//                .setMultipartParameter("user_address", address.getText().toString().trim())
//                .setMultipartParameter("user_city", city.getText().toString().trim())
//                .setMultipartParameter("user_role", "vendor")
//                .setMultipartParameter("user_gender", selectedGender)
//                .setMultipartParameter("user_lat", String.valueOf(lat))
//                .setMultipartParameter("user_lon", String.valueOf(lon))
//                .setMultipartParameter("services", items)
//                .setMultipartParameter("charges", charges.getText().toString().trim())
//                .asString()
//                .withResponse()
//                .setCallback(new FutureCallback<Response<String>>() {
//                    @Override
//                    public void onCompleted(Exception e, Response<String> result) {
//                        resultPath = null;
//                        if(e != null){
//                            misc.showToast("Internet Connection Problem");
//                            pd.dismiss();
//                            return;
//                        }
//                        String response = result.getResult();
//                        if(response.isEmpty()){
//                            pd.dismiss();
//                            misc.showToast("Email, Phone, or CNIC already exists");
//                            return;
//                        }
//                        else{
//                            pd.dismiss();
//                            misc.showToast(result.getResult());
//                            Intent intent = new Intent(RegisterServiceActivity.this, LoginActivity.class);
//                            startActivity(intent);
//                            finish();
//                        }
//                    }
//                });
//    }
//
//    private void registerWithoutImage(){
//        final ProgressDialog pd = new ProgressDialog(this);
//        pd.setMessage("Registration in process...");
//        pd.setCancelable(false);
//        pd.show();
//
//        String items = "";
//        for(String item : selectedServices){
//            items += item+",";
//        }
//
//        JsonObject jsonObject = new JsonObject();
//        jsonObject.addProperty("user_name", name.getText().toString().trim());
//        jsonObject.addProperty("user_email", email.getText().toString().trim());
//        jsonObject.addProperty("user_phone", phone.getText().toString().trim());
//        jsonObject.addProperty("user_address", address.getText().toString().trim());
//        jsonObject.addProperty("user_city", city.getText().toString().trim());
//        jsonObject.addProperty("user_cnic", cnic.getText().toString().trim());
//        jsonObject.addProperty("user_password", password.getText().toString());
//        jsonObject.addProperty("user_role", "vendor");
//        jsonObject.addProperty("user_lat", lat);
//        jsonObject.addProperty("user_lon", lon);
//        jsonObject.addProperty("user_gender", selectedGender);
//        jsonObject.addProperty("services", items);
//        jsonObject.addProperty("charges", charges.getText().toString().trim());
//
//        Ion.with(this)
//                .load(misc.ROOT_PATH+"new_user")
//                .setJsonObjectBody(jsonObject)
//                .asString()
//                .withResponse()
//                .setCallback(new FutureCallback<Response<String>>() {
//                    @Override
//                    public void onCompleted(Exception e, Response<String> result) {
//                        resultPath = null;
//                        if(e != null){
//                            misc.showToast("Internet Connection Problem");
//                            pd.dismiss();
//                            return;
//                        }
//                        String response = result.getResult();
//                        if(response.isEmpty()){
//                            pd.dismiss();
//                            misc.showToast("Email, Phone, or CNIC already exists");
//                            return;
//                        }
//                        else{
//                            pd.dismiss();
//                            misc.showToast(result.getResult());
//                            Intent intent = new Intent(RegisterServiceActivity.this, LoginActivity.class);
//                            startActivity(intent);
//                            finish();
//                        }
//                    }
//                });
//    }
//
//    @Override
//    public void onBackPressed() {
//        Intent intent = new Intent(this, RegisterAsActivity.class);
//        startActivity(intent);
//        finish();
//    }
//
//    public void getCoordinates(String location) {
//        Geocoder gc = new Geocoder(this);
//        LatLng latLng = null;
//        try {
//            List<Address> address = gc.getFromLocationName(location, 1);
//            Address add = address.get(0);
//            lat = add.getLatitude();
//            lon = add.getLongitude();
//           // misc.showToast("Lat : " + lat + " Lon : " + lon);
//        } catch (IOException e) {
//            misc.showToast("Service Location not found");
//            e.printStackTrace();
//        }
        }
    public void next (View view) {
        // Do something in response to button
//        Intent intent = new Intent(this, ServiceHomeActivity.class);
//        startActivity(intent);
//        finish();
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, RegisterAsActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    public void onClick(View v) {

    }
}

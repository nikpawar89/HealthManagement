package com.example.nikpa.healthmanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    //view objects
    private TextView textViewUserEmail;
    private Button buttonLogout;

    //defining a database reference
    private DatabaseReference databaseReference;

    //our new views
    private EditText editTextName, editTextAddress;
    private Button buttonSave;


    // gunjans code
  /*  EditText textBoxfirstname=(EditText)findViewById(R.id.editTextfirstname);
    EditText textBoxlastname=(EditText)findViewById(R.id.editTextlastname);
    EditText textBoxemergency=(EditText)findViewById(R.id.editTextemergency);
    EditText textBoxphone=(EditText)findViewById(R.id.editTextphonenumber);
    EditText textBoxage=(EditText)findViewById(R.id.editTextage);
    EditText textusername=(EditText)findViewById(R.id.editTextusername) ;
    EditText textemailid=(EditText) findViewById(R.id.editTextemailid);
    EditText textpassword=(EditText) findViewById(R.id.editTextpassword);

    String vfirstname= textBoxfirstname.getText().toString();
    String vlastname=textBoxlastname.getText().toString();
    String vemergency=textBoxemergency.getText().toString();
    String vphone=textBoxphone.getText().toString();
    int phone=Integer.parseInt(vphone);
    String vage=textBoxphone.getText().toString();
    int age=Integer.parseInt(vage);
    String vusername=textusername.getText().toString().trim();

    String vemailid=textemailid.getText().toString().trim();*/




    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       // validation

        Button buttonsubmit=(Button) findViewById(R.id.buttonsubmit);

        buttonsubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText textBoxfirstname=(EditText)findViewById(R.id.editTextfirstname);
                EditText textBoxlastname=(EditText)findViewById(R.id.editTextlastname);
                EditText textBoxemergency=(EditText)findViewById(R.id.editTextemergency);
                EditText textBoxphone=(EditText)findViewById(R.id.editTextphonenumber);
                EditText textBoxage=(EditText)findViewById(R.id.editTextage);
                EditText textusername=(EditText)findViewById(R.id.editTextusername) ;
                EditText textemailid=(EditText) findViewById(R.id.editTextemailid);
                EditText textpassword=(EditText) findViewById(R.id.editTextpassword);

                String vfirstname= textBoxfirstname.getText().toString();
                String vlastname=textBoxlastname.getText().toString();
                String vemergency=textBoxemergency.getText().toString();
                String vphone=textBoxphone.getText().toString();
                    double phone=0;
                int age=0;
                if(vphone.length()==0)
                {
                    phone=0;
                }
                else
                {
                    phone=Double.parseDouble(vphone);
                }


                String vage=textBoxage.getText().toString();

                if(vage.length()==0)
                {
                    age=0;
                }
                else
                {
                    age=Integer.parseInt(vage);
                }



                String vusername=textusername.getText().toString().trim();
               // vusername=vusername.trim();
                String vemailid=textemailid.getText().toString().trim();
                //vemailid=vemailid.trim();
                String vextpassword=textpassword.getText().toString().trim();



//&& vphone.length()==10 && vage.length()==2
                Toast.makeText(getApplicationContext(),"Phone value is "+vphone+" phone length is "+vphone.length(),Toast.LENGTH_SHORT).show();

                Toast.makeText(getApplicationContext(),"age value is"+vage+"and age length is"+vage.length(),Toast.LENGTH_SHORT).show();

                Toast.makeText(getApplicationContext(),"is email valid "+isvalidemailid(vemailid),Toast.LENGTH_SHORT).show();

                Toast.makeText(getApplicationContext(),"is password valid "+isvalidpassword(vextpassword),Toast.LENGTH_SHORT).show();

                if(isvalidpassword(textpassword.getText().toString().trim()) && vphone.length()==10 && vage.length()==2 && isvalidemailid(vemailid)) {
                    // Toast.makeText( this, Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(),"inserting value",Toast.LENGTH_SHORT).show();

                   /* UserInformation(String firstName, String lastName,String emailId,int age,int phoneNumber,String emergencyContact,
                            String username ,String password)*/
                    saveUserInformation(vfirstname,vlastname,vemailid,age,phone,vemergency,vusername,vextpassword);

                }
                else {
                    Toast.makeText(getApplicationContext(),"Invalid ", Toast.LENGTH_SHORT).show();
                }






            }
            public boolean isvalidpassword(final String password){
                Pattern pattern;
                Matcher matcher;

                final String password_pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";
                pattern = Pattern.compile(password_pattern);
                matcher=pattern.matcher(password);

                return matcher.matches();
            }

            public boolean isvalidemailid(final String email){
                Pattern pattern;
                Matcher matcher;

               // final String email_pattern="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$";
                final String email_pattern= ".+@.+\\.[a-z]+";
                pattern = Pattern.compile(email_pattern);
                matcher=pattern.matcher(email);

                return matcher.matches();
            }

        });



        //getting the database reference
        databaseReference = FirebaseDatabase.getInstance().getReference();

        //getting the views from xml resource
       /* editTextAddress = (EditText) findViewById(R.id.editTextAddress);
        editTextName = (EditText) findViewById(R.id.editTextName);
        buttonSave = (Button) findViewById(R.id.buttonSave);*/

      //  buttonSave.setOnClickListener(this);
    }


 /*   private void saveUserInformation() {
        //Getting values from database
        String name = editTextName.getText().toString().trim();
        String add = editTextAddress.getText().toString().trim();

        //creating a userinformation object
        UserInformation userInformation = new UserInformation(name, add);

        //getting the current logged in user
        //FirebaseUser user = firebaseAuth.getCurrentUser();

        //saving data to firebase database
        *//*
        * first we are creating a new child in firebase with the
        * unique id of logged in user
        * and then for that user under the unique id we are saving data
        * for saving data we are using setvalue method this method takes a normal java object
        * *//*
        databaseReference.child("test").setValue(userInformation);

        //displaying a success toast
        Toast.makeText(this, " chal save kardiya teri info", Toast.LENGTH_LONG).show();
    }*/


    private void saveUserInformation(String firstName, String lastName,String emailId,int age,double phoneNumber,String emergencyContact,
                                     String username ,String password) {
        //Getting values from database
      /*  String name = editTextName.getText().toString().trim();
        String add = editTextAddress.getText().toString().trim();*/

        //creating a userinformation object

      /*  public String firstName;
        public String lastName;
        public String emailId;
        public int age;
        public int phoneNumber;
        public String emergencyContact;
        public String username;
        public String password;*/
        UserInformation userInformation = new UserInformation(firstName,lastName,emailId,age,phoneNumber,emergencyContact,username,password);

        //getting the current logged in user
        //FirebaseUser user = firebaseAuth.getCurrentUser();

        //saving data to firebase database
        /*
        * first we are creating a new child in firebase with the
        * unique id of logged in user
        * and then for that user under the unique id we are saving data
        * for saving data we are using setvalue method this method takes a normal java object
        * */
        databaseReference.child(emailId).setValue(userInformation);

        //displaying a success toast
        Toast.makeText(this, " chal save kardiya teri info", Toast.LENGTH_LONG).show();
    }



   /* @Override
    public void onClick(View view) {

        if(view == buttonSave){
            saveUserInformation();
        }

    }*/
}

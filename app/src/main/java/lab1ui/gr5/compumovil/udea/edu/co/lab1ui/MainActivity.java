package lab1ui.gr5.compumovil.udea.edu.co.lab1ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String spinnerArray[];
    EditText name;
    EditText lastName;
    EditText address;
    EditText mail;
    EditText phone;
    DatePicker date;
    AutoCompleteTextView country;
    RadioGroup gender;
    CheckBox favorite;
    Toast check;
    TextView vista;
    Spinner s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerArray = new String[]{"hobbie1", "hobbie2", "hobbie3..."};

        s = (Spinner) findViewById(R.id.hobbies);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray);
        s.setAdapter(adapter);
        //Capturando para el text view

        name = (EditText)findViewById(R.id.name);
        lastName = (EditText)findViewById(R.id.lastName);
        address = (EditText)findViewById(R.id.address);
        mail = (EditText)findViewById(R.id.emailAddress);
        phone = (EditText)findViewById(R.id.phone);
        date = (DatePicker)findViewById(R.id.date);
        country = (AutoCompleteTextView)findViewById(R.id.country);
        gender = (RadioGroup)findViewById(R.id.radioGroup);
        favorite = (CheckBox)findViewById(R.id.favorite);
        vista = (TextView)findViewById(R.id.view);




    }

    public void onClick(View v){

        if(validate()){

            String finalText= "Nombre : " + name.getText().toString() + "\n";
            finalText = finalText + "Apellidos: " + lastName.getText().toString() + "\n";
            finalText = finalText + "Telefono: " + phone.getText().toString() + "\n";
            finalText = finalText + "E-mail: " + mail.getText().toString() + "\n";
            finalText = finalText + "Dirección: " + address.getText().toString() + "\n";
            finalText = finalText + "Pais: " + country.getText().toString();
            finalText = finalText + "Fecha de nacimiento: Dia: " + date.getDayOfMonth() + " - Mes: " + date.getMonth() + " - Año: " + date.getYear() + "\n";
            if(gender.indexOfChild(gender.findViewById(gender.getCheckedRadioButtonId())) == 0){
                finalText = finalText + "Genero: Femenino\n";
            }else finalText = finalText + "Genero: MAsculino\n";
            finalText = finalText + "Hobbie: " +  s.getSelectedItem().toString() + "\n";
            if(favorite.isChecked()){
                finalText = finalText + "Favorito!!!!";
            }
            vista.setText(finalText);
            check = Toast.makeText(this, finalText, Toast.LENGTH_SHORT);
            check.show();

        }

    }

    boolean validate(){

        if(name.getText().toString().equals("")){

            check = Toast.makeText(this, "Verificar Nombre", Toast.LENGTH_SHORT);
            check.show();
            return false;
        }if(lastName.getText().toString().equals("")){
            check = Toast.makeText(this, "Verificar Apellidos", Toast.LENGTH_SHORT);
            check.show();
            return false;
        }if(address.getText().toString().equals("")) {
            check = Toast.makeText(this, "Dirección", Toast.LENGTH_SHORT);
            check.show();
            return false;
        }if(mail.getText().toString().equals("")) {
            check = Toast.makeText(this, "Vericar E-mail", Toast.LENGTH_SHORT);
            check.show();
            return false;
        }if(phone.getText().toString().equals("")) {
            check = Toast.makeText(this, "Verificar Telefono", Toast.LENGTH_SHORT);
            check.show();
            return false;
        }if(country.getText().toString().equals("")) {
            check = Toast.makeText(this, "Verificar Pais", Toast.LENGTH_SHORT);
            check.show();
            return false;
        }if(gender.indexOfChild(gender.findViewById(gender.getCheckedRadioButtonId())) == -1) {
            check = Toast.makeText(this, "Seleccione genero", Toast.LENGTH_SHORT);
            check.show();
            return false;
        }
        return true;
    }


}

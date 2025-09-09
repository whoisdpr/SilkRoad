package silkroad;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import silkroad.R;

import java.util.Calendar;

public class GuideRegisterActivity extends AppCompatActivity {

    private ImageView imageProfile;
    private Button btnAddPhoto, btnSaveProfile;
    private EditText editFirstName, editLastName, editDocumentNumber, editEmail, editPhone, editAddress;
    private Spinner spinnerDocumentType;
    private TextView textBirthDate;
    private LinearLayout languagesContainer;

    private String[] idiomas = {"Español", "Inglés", "Francés", "Alemán", "Italiano", "Chino", "Japonés"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_register);

        imageProfile = findViewById(R.id.imageProfile);
        btnAddPhoto = findViewById(R.id.btnAddPhoto);
        btnSaveProfile = findViewById(R.id.btnSaveProfile);

        editFirstName = findViewById(R.id.editFirstName);
        editLastName = findViewById(R.id.editLastName);
        editDocumentNumber = findViewById(R.id.editDocumentNumber);
        editEmail = findViewById(R.id.editEmail);
        editPhone = findViewById(R.id.editPhone);
        editAddress = findViewById(R.id.editAddress);
        spinnerDocumentType = findViewById(R.id.spinnerDocumentType);
        textBirthDate = findViewById(R.id.textBirthDate);
        languagesContainer = findViewById(R.id.languagesContainer);

        // Spinner Tipo de Documento
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.document_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDocumentType.setAdapter(adapter);

        // Date Picker para Fecha de nacimiento
        textBirthDate.setOnClickListener(v -> showDatePicker());

        // Agregar checkboxes de idiomas dinámicamente
        for (String idioma : idiomas) {
            CheckBox cb = new CheckBox(this);
            cb.setText(idioma);
            cb.setTextSize(14f);
            cb.setPadding(8, 8, 8, 8);
            languagesContainer.addView(cb);
        }

        // Botón Guardar perfil (solo navegación de ejemplo)
        btnSaveProfile.setOnClickListener(v -> {
            // Aquí podrías validar y guardar el perfil, por ahora solo muestra un Toast y navega al dashboard.
            Toast.makeText(this, "Perfil guardado", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, GuideDashboardActivity.class);
            startActivity(intent);
            finish();
        });

        // Botón agregar foto (lógica mínima, solo Toast)
        btnAddPhoto.setOnClickListener(v -> {
            Toast.makeText(this, "Función de agregar foto pendiente", Toast.LENGTH_SHORT).show();
        });
    }

    private void showDatePicker() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR) - 18;
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(this,
                (view, year1, month1, dayOfMonth) -> {
                    String fecha = String.format("%02d/%02d/%04d", dayOfMonth, month1 + 1, year1);
                    textBirthDate.setText(fecha);
                }, year, month, day);
        dialog.show();
    }
}
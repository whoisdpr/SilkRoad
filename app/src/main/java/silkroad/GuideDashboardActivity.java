package silkroad;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import silkroad.TourOfferAdapter.TourOffer;
import java.util.ArrayList;
import java.util.List;
import android.widget.Toast;

public class GuideDashboardActivity extends AppCompatActivity {

    private ImageView imageProfileDashboard, imageProfileMini;
    private TextView textGuideName, textGuideFullName, textGuideLanguages;
    private RecyclerView recyclerTourOffers;
    private ImageButton menuButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_dashboard);

        // AppBar
        imageProfileDashboard = findViewById(R.id.imageProfileDashboard);
        textGuideName = findViewById(R.id.textGuideName);
        menuButton = findViewById(R.id.menuButton);

        // Card perfil
        imageProfileMini = findViewById(R.id.imageProfileMini);
        textGuideFullName = findViewById(R.id.textGuideFullName);
        textGuideLanguages = findViewById(R.id.textGuideLanguages);

        // Set demo data for profile (could be loaded from intent, database, etc)
        textGuideName.setText("Ana Salazar");
        textGuideFullName.setText("Ana Salazar");
        textGuideLanguages.setText("Español, Inglés, Francés");

        // Feed de ofertas de tours
        recyclerTourOffers = findViewById(R.id.recyclerTourOffers);
        recyclerTourOffers.setLayoutManager(new LinearLayoutManager(this));
        List<TourOffer> demoOffers = new ArrayList<>();
        demoOffers.add(new TourOffer("Tour en Cusco", "15/09/2025", "Tour de 3 días por el Valle Sagrado y Machu Picchu."));
        demoOffers.add(new TourOffer("City Tour Lima", "20/09/2025", "Recorrido histórico por el centro de Lima, incluye Miraflores y Barranco."));
        demoOffers.add(new TourOffer("Aventura en Arequipa", "01/10/2025", "Explora el Cañón del Colca y disfruta de la gastronomía arequipeña."));
        TourOfferAdapter adapter = new TourOfferAdapter(demoOffers, new TourOfferAdapter.OnTourOfferActionListener() {
            @Override
            public void onAccept(int position) {
                Toast.makeText(GuideDashboardActivity.this, "Tour aceptado", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onReject(int position) {
                Toast.makeText(GuideDashboardActivity.this, "Tour rechazado", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerTourOffers.setAdapter(adapter);

        // Menú (puedes abrir un menú futuro aquí)
        menuButton.setOnClickListener(view -> {
            Toast.makeText(this, "Función de menú próximamente", Toast.LENGTH_SHORT).show();
            // Ejemplo: startActivity(new Intent(this, GuideHistoryActivity.class));
        });
    }
}
package com.example.spinnerandlistview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,AdapterView.OnItemClickListener {

    ListView list;
    Spinner spin1;
    Spinner spin2;
    TextView population;
    TextView square;
    String[] continents;
    int line;
    String[][] countries;
    String[][][][] data;
    String[][][] cities;
    int country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        line=0;

        spin1=(Spinner)findViewById(R.id.spin1);
        spin2=(Spinner)findViewById(R.id.spin2);

        list=(ListView) findViewById(R.id.list);
        population=(TextView) findViewById(R.id.population);
        square=(TextView) findViewById(R.id.square);

        continents= new String[]{"continent", "Africa", "Europe", "Asia", "America"};

        countries=new String[][]{{"country","Nigeria","Ethiopia","Egypt","South Africa","Tanzania","Uganda","Algeria"},
                {"country","Russia","Germany","United Kingdom","France","Italy","Spain","Ukraine"},
                {"country","China","India","Indonesia","Pakistan","Bangladesh","Japan","Philippines"}
                ,{"country","United States","Brazil","Mexico","Colombia","Argentina","Canada","Peru"}};

        cities=new String[][][] {{ {"Lagos","Kano","Ibadan","Benin City","Port Harcourt"}, //Niferia
                {"Addis Ababa","Mekelle","Gondar", "Dire Dawa","Hawassa" },//Ethiopia
                {"Ismailia","Giza","Alexandria","Cairo","Port Said"},
                {"Aberdeen","Johannesburg","Durban","Port Elizabeth","Pretoria" },
                {"Dar es Salaam","Moshi","Morogoro","Dodoma","Kasulu"},
                {"Kampala","Mukono","Kira","Mityana","Wakiso District"},
                {"Oran","Constantine","Batna","Algiers","Annaba" }},
                { {"Saint Petersburg","Novosibirsk","Yekaterinburg","Moscow","Kazan"},
                        {"Haan","Kaarst","Kaltenkirchen","Berlin","Kenzingen" },
                        {"Bristol","Cardiff","Cambridge","London","Leicester" },
                        {"Marseille","Lyon","Toulouse","Paris" ,"Nice"},
                        {"Naples","Turin","Palermo","Rome","Milan" },
                        {"Barcelona","Valencia","Seville","Madrid","Málaga" },
                        {"Odesa","Donetsk","Dnipro","Kyiv","Kharkiv" }} ,
                { {"Macau","Hong Kong","Tianjin","Beijing","Bengbu"},
                        {"Mumbai","Chennai","Bangalore","New Delhi","Hyderabad" },
                        {"Surabaya","Bekasi","Bandung","Jakarta","c" },
                        {"Lahore","Gujranwala","Peshawar","Multan","Hyderabad" },
                        {"Chittagong","Rajshahi","Mymensingh","Dhaka" ,"Khulna"},
                        {"Seto","Ichinomiya","Okazaki","Tokyo","Toyohashi" },
                        {"Quezon City","Palayan","Puerto Princesa","Manila","San Juan" }},
                { {"Sitka","Juneau","Wrangell","Washington, D.C.","Oklahoma City"},
                        {"Goiânia","Manaus","Rio de Janeiro","Brasília","São Paulo" },
                        {"Ecatepec","Guadalajara","Puebla City","Mexico City","Ciudad Juárez" },
                        {"Cali","Cúcuta","Cartagena","Bogotá","Santa Marta" },
                        {"Rosario","Mendoza","San Miguel de Tucumán","Buenos Aires","Mar_del_Plata" },
                        {"Airdrie","Camrose","Leduc","Ottawa","Lacombe" },
                        {"Cuzco","Huancayo","Huaraz","Lima","Ica" }}};

        data = new String[][][][] { {    { {"999.6 km2","23,437,435"},{"499 km2","3,931,300"},{"6,800 km2","3,034,200"},
                {"1,204 km2 ","1,495,800"},{"369 km2","1,005,904"}},
                {{"527 km2","3,384,569"},{"24.44km2","310,436"},{"192.27 km2","299,969"},
                        {"1,213 km2","493,000"},{"50 km2","315,267"}},
                {{"210 km2","366,669"},{"1,579.75 km","8,800,000"},{"2,679 km2 ","5,200,000"},
                        {"3,085.12 km2","9,908,788"},{"1,351.1 km2","603,787"}},
                {{"185.7 km2","196,670"},{"1,644.98 km2","5,635,127"},{"225.91 km2","3,720,953"},
                        {"251.03 km2","967,677"},{"687.54 km2","2,472,612"}},
                {{"1,493 km2","4,364,541"},{"59 km2","201,150"},
                        {"360 km2","315,866"},{"2,576 km2","410,956"},
                        {"878.8 km2","234,452"}},
                {{"189 km2","1,650,600"},{"31.4 km2","161,996"},{"98.83 km2","317,157"},
                        {"21 km2","48,002"},{"1,906.7 km2","1,997,418"}} ,
                {{"2,121 km2","803,329"},{"2,288 km2","464,219"},
                        {"85 km2","290,645"},{"363 km2","3,915,811"},{"49 km2","257,359"}}},
                {{ {"1,439 km2","5,351,935"} ,{"502.7 km2","1,473,754"},
                        {"495 km2","1,349,772"},{"2,511 km2","12,506,468"},
                        {"425.3 km2","1,143,535"}},
                        {{"24.22 km2","30,406"},{"37.48 km2","43,493"},
                                {"23.1 km2","22,109"},{"891.1 km2","3,769,495"},{"36.93 km2","10,340"}},
                        {{"110 km2","463,400"},{"140.3 km2","364,248"},
                                {"40.7 km2","124,798"},{"1,572 km2","8,961,989"},
                                {"4.9 km2","329,839"}},
                        {{"240.62 km2","869,815"},{"47.87 km2","516,092"},
                                {"118.3 km2","479,553"},{"105.4 km2","2,148,271"},
                                {"71.92 km2","340,017"}},
                        {{"119.02 km2","967,068"},{"130.17 km2","869,206"},
                                {"158.9 km2","676,118"},{"1,285 km2 ","4,342,212"},
                                {"181.76 km2","1,399,860"}},
                        {{"101.4 km2","1,620,343"},{"134.65 km2","801,456"},
                                {"140 km2","688,711"},{"604.31 km2","3,223,334"},
                                {"398 km2","571,026"}},
                        {{"162.42 km2","1,016,515"},{"358 km2","929,063"},
                                {"409,718 km2","998,103"},{"839 km2","2,950,800"},
                                {"350 km2","2,139,036"}}}, {
                {{"115.3 km2", "696,100"}, {"2,755km2", "7,500,700"}, {"2,755km2", "15,621,200"}
                        , {"16,410.5 km2", "21,542,000"}, {"5,952.14 km2", "3,164,467"}},
                {{"603 km2", "12,478,447"}, {"426 km2", "7,088,000"}, {"709km2", "8,443,675"}
                        , {"42.7 km2", "257,803"}, {"625 km2", "6,809,970"}},
                {{"350.5 km2", "2,898,240"}, {"210.49 km2", "2,931,897"},
                        {"167.67 km2", "2,507,880"}, {"662.3 km2", "10,770,487"},
                        {"265.1 km2", "2,279,790"}},
                {{"1,772 km2", "11,126,285"}, {"240 km2", "2,027,001"},
                        {"215 km2", "1,970,042"}, {"286 km2", "1,871,843"},
                        {"625 km2", "6,809,970"}},
                {{"5,282.92 km2", "8,440,000"}, {"96.68 km2", "763,952"},
                        {"91.315 km2", "476,543"}, {"306 km2", "8,906,039"},
                        {"59.57 km2", "2,001,000"}},
                {{"111.40 km2", "127,659"}, {"113.82 km2", "379,654"},
                        {"387.20 km2", "386,999"}, {"2,194.07 km2", "13,929,280"},
                        {"261.86 km2", "377,453"}},
                {{"166.20 km2", "2,936,116"}, {"101.40 km2", "41,041"},
                        {"2,381.02 km2", "255,116"}, {"42.88 km2", "1,780,148"}, {"5.95 km2", "122,180"}}
        },{{{"12,471.16 km2","8,881"},{"8,429.64","31,275"},
                {"9,004.37 km2","2,502"},{"177.0 km2","705,749"},{"181,037 km2","3,956,971"}},
                {{"789 km2","1,466,105"},{"11,401.092 km2","2,182,763"},
                        {"1,221 km2","6,718,903"},{"5,802 km2","4,291,577"},{"1,521.11 km2","12,176,866"}},
                {{"160.17 km2","1,656,107"},{"151 km2","1,460,148"},
                        {"534.32 km2","1,576,259"},{"1,485 km2","8,918,653"},
                        {"321.19 km2","1,321,004"}},
                {{"619 km2","2,227,642"},{"1,176 km2","711,715"},{"572 km2","914,552"},
                        {"1,587 km2","7,412,566"},{"2,393.65 km2","499,192"}}
                ,{{"178.69 km2","1,276,000"},{"54 km2","1,055,679"},
                {"480 km2","830,000"},{"203 km2","15,594,428"},{"79.48 km2","614,350"}}
                ,{{"84.57 km2","61,581"},{"42.62 km2","18,742"},{"42.44 km2","29,993"},
                {"6,767.41 km2","1,323,783"},{"20.81 km2","13,057"}},
                {{"385.1 km2","428,450"},{"319.41 km2","456,250"},{"370.03 km2","118,836"},
                        {"2,819.3 km2","10,072,000"},{"7,894 km2","282,407"}}}};

        spin1.setOnItemSelectedListener(this);
        spin2.setOnItemSelectedListener(this);

        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,continents);
        spin1.setAdapter(adp);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        population.setText("poplation = "+data[line][country][position][1]);
        square.setText("area = "+data[line][country][position][0]);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId()==(R.id.spin1))
        {
            if (position!=0)
            {
                ArrayAdapter<String> adp2=new ArrayAdapter<String>(this
                        ,R.layout.support_simple_spinner_dropdown_item,countries[position-1]);
                spin2.setAdapter(adp2);
                line=position-1;
            }
            else
            {
                spin2.setAdapter(null);
            }
        }

        else if(parent.getId() == (R.id.spin2))
        {
            if (position != 0) {
                country = position-1;
                list.setVisibility(View.VISIBLE);

                ArrayAdapter<String> adp = new ArrayAdapter<String>(this
                        , R.layout.support_simple_spinner_dropdown_item, cities[line][position - 1]);
                list.setAdapter(adp);
                list.setOnItemClickListener(this);
            }
            else
            {
                list.setVisibility(View.INVISIBLE);
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
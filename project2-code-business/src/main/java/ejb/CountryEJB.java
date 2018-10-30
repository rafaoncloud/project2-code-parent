package ejb;

import data.Country;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Stateless
@LocalBean
public class CountryEJB {

    @PersistenceContext
    private EntityManager em;

    public CountryEJB(){

    }

    public String echo(String name){
        return "Test echo: " + name;
    }

    public List<dto.Country> getAllCountries(String token, boolean descending)
    {
        List<data.Country> jpaCountries =  getAllCountriesCRUD(descending);
        List<dto.Country> dtoCourses = new ArrayList<>();

        for (data.Country jpaCountry : jpaCountries)
        {
            dto.Country dtoCountry = new dto.Country();
            utils.Utils.getDozerBeanMapper().map(jpaCountry, dtoCountry);
            dtoCourses.add(dtoCountry);
        }

        return dtoCourses;
    }
    public dto.Country getCountryByName(String token, String country) throws Exception
    {
        dto.Country dtoCountry = new dto.Country();

        utils.Utils.getDozerBeanMapper().map(getCountryByNameCRUD( country ), dtoCountry);

        return dtoCountry;
    }

    public dto.Country getCountry(String token, long countryId) throws Exception
    {
        dto.Country dtoCountry = new dto.Country();

        utils.Utils.getDozerBeanMapper().map(getCountryCRUD( countryId ), dtoCountry);

        return dtoCountry;
    }

    public void addAllCountry(String token)
    {
        SetAllCountriesCRUD();
    }

    //
    // CRUD Operations
    //

    private data.Country getCountryCRUD(long countryId) throws Exception
    {
        try
        {
            Country country = em.find(Country.class, countryId);

            if (country == null)
                throw new Exception("Country with ID " + countryId + " not found.");

            return country;
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }
    private data.Country getCountryByNameCRUD(String countryName) throws Exception
    {
        try
        {
            String queryText = "from Country c where c.CountryName = :CountryName";

            Query query = em.createQuery(queryText);

            query.setParameter("CountryName", countryName);

            Country country =  (Country) query.getResultList();

            if (country == null)
                throw new Exception("Country with name " + countryName + " not found.");

            return country;
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }

    private List<data.Country> getAllCountriesCRUD(boolean descending)
    {
        try
        {
            String queryText = "Select distinct c from Country c order by c.CountryName";

            if (descending)
                queryText += " desc";
            else
                queryText += " asc";

            Query query = em.createQuery(queryText);

            return query.getResultList();
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }
    private void SetAllCountriesCRUD()
    {
       List<data.Country> jpaCountries =  getAllCountriesCRUD(false);

        if(jpaCountries.size() > 0)
            return;


        String strCountries = "Afghanistan,Albania,Algeria,American Samoa,Andorra,Angola,Anguilla,Antigua & Barbuda,Argentina,Armenia,Aruba,Australia,Austria,Azerbaijan,Bahamas, The,Bahrain,Bangladesh,Barbados,Belarus,Belgium,Belize,Benin,Bermuda,Bhutan,Bolivia,Bosnia & Herzegovina,Botswana,Brazil,British Virgin Is.,Brunei,Bulgaria,Burkina Faso,Burma,Burundi,Cambodia,Cameroon,Canada,Cape Verde,Cayman Islands,Central African Rep.,Chad,Chile,China,Colombia,Comoros,Congo, Dem. Rep.,Congo, Repub. of the,Cook Islands,Costa Rica,Cote d'Ivoire,Croatia,Cuba,Cyprus,Czech Republic,Denmark,Djibouti,Dominica,Dominican Republic,East Timor,Ecuador,Egypt,El Salvador,Equatorial Guinea,Eritrea,Estonia,Ethiopia,Faroe Islands,Fiji,Finland,France,French Guiana,French Polynesia,Gabon,Gambia, The,Gaza Strip,Georgia,Germany,Ghana,Gibraltar,Greece,Greenland,Grenada,Guadeloupe,Guam,Guatemala,Guernsey,Guinea,Guinea-Bissau,Guyana,Haiti,Honduras,Hong Kong,Hungary,Iceland,India,Indonesia,Iran,Iraq,Ireland,Isle of Man,Israel,Italy,Jamaica,Japan,Jersey,Jordan,Kazakhstan,Kenya,Kiribati,Korea, North,Korea, South,Kuwait,Kyrgyzstan,Laos,Latvia,Lebanon,Lesotho,Liberia,Libya,Liechtenstein,Lithuania,Luxembourg,Macau,Macedonia,Madagascar,Malawi,Malaysia,Maldives,Mali,Malta,Marshall Islands,Martinique,Mauritania,Mauritius,Mayotte,Mexico,Micronesia, Fed. St.,Moldova,Monaco,Mongolia,Montserrat,Morocco,Mozambique,Namibia,Nauru,Nepal,Netherlands,Netherlands Antilles,New Caledonia,New Zealand,Nicaragua,Niger,Nigeria,N. Mariana Islands,Norway,Oman,Pakistan,Palau,Panama,Papua New Guinea,Paraguay,Peru,Philippines,Poland,Portugal,Puerto Rico,Qatar,Reunion,Romania,Russia,Rwanda,Saint Helena,Saint Kitts & Nevis,Saint Lucia,St Pierre & Miquelon,Saint Vincent and the Grenadines,Samoa,San Marino,Sao Tome & Principe,Saudi Arabia,Senegal,Serbia,Seychelles,Sierra Leone,Singapore,Slovakia,Slovenia,Solomon Islands,Somalia,South Africa,Spain,Sri Lanka,Sudan,Suriname,Swaziland,Sweden,Switzerland,Syria,Taiwan,Tajikistan,Tanzania,Thailand,Togo,Tonga,Trinidad & Tobago,Tunisia,Turkey,Turkmenistan,Turks & Caicos Is,Tuvalu,Uganda,Ukraine,United Arab Emirates,United Kingdom,United States,Uruguay,Uzbekistan,Vanuatu,Venezuela,Vietnam,Virgin Islands,Wallis and Futuna,West Bank,Western Sahara,Yemen,Zambia,Zimbabwe";

        List<String> lstCountries = Arrays.asList( strCountries.split( "," ) );

        for (String strCountry : lstCountries )
        {
            Country country = new Country( strCountry.trim() );
            em.persist(country);
        }


    }
}

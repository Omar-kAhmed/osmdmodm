package nationalize;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Comparator;
import java.util.Optional;
public record Nationality(long count, String name, @SerializedName("country") List<Country> countries) {
    public record Country(String countryId, float probability) {}



    public Optional<Country> getMostLikelyCountry() {
        return countries.stream().max(Comparator.comparingDouble(Country::probability));
    }
}

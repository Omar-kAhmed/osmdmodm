
/**
 * Package to predict the nationality of a person based on a last name. The
 * current implementation uses the
 * <a href="https://nationalize.io/">nationalize.io</a> API.
 *
 * <p>Example of use:
 * {@literal :
 * var client = NationalizeClient.newInstance();
 * var nationality = client.getNationality("Torvalds");
 * var mostLikelyCountry = nationality.getMostLikelyCountry();
 * }
 */
package nationalize;
package api.models;

public class Address {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;

        public Address() {}

        public String getStreet() {
            return street;
        }

        public String getSuite() {
            return suite;
        }

        public String getCity() {
            return city;
        }

        public String getZipcode() {
            return zipcode;
        }

        public Geo getGeo() {
            return geo;
        }
}
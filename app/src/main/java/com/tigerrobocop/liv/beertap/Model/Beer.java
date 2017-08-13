package com.tigerrobocop.liv.beertap.Model;

import java.io.Serializable;

/**
 * Created by Livia on 12/08/2017.
 */

public class Beer implements Serializable {
        public int id;
        public String type;
        public String brand;
        public int origin;
        public String city;
        public int photoID;
        public String photoPath;
        public String website;

        // constructor from local resources
        public Beer(int _id, String _type, String _brand, int _origin, String _city, int _photoID, String _website){
            this.id = _id;
            this.type = _type;
            this.brand = _brand;
            this.origin = _origin;
            this.city = _city;
            this.photoID = _photoID;
            this.website = _website;
        }

        // constructor from user input
        public Beer(int _id, String _type, String _brand, int _origin, String _city, String _photoPath, String _website){
            this.id = _id;
            this.type = _type;
            this.brand = _brand;
            this.origin = _origin;
            this.city = _city;
            this.photoPath = _photoPath;
            this.website = _website;
        }
}

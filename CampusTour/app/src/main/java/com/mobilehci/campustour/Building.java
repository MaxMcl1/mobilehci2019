package com.mobilehci.campustour;

public enum Building {

    BOYD_ORR(
        "Boyd Orr Building",
        "It was designed in 1964 by architects JL Gleave & Partners primarily as a general science building to act as an overflow for the overcrowded departmental buildings largely for first-year students given the projected 50% increase in students during the late 1960s and early 1970s.",
        false,
        new int[] {R.drawable.ic_accessible, R.drawable.ic_wifi, R.drawable.ic_wc, R.drawable.ic_local_cafe},
        55.8736,
        -4.2926,
            R.drawable.boydorr
    ),
    ST_ANDREWS(
        "St Andrews Building",
        "The St Andrew's Building was originally built in 1913 by Walter Robert Watson of Cowan & Watson for the Glasgow & West of Scotland College of Domestic Science, established in 1908. The college was renamed Queens College in 1975, and the building was acquired from Glasgow Caledonian University by the University in 1998. On 11 April 1999 St Andrew's College of Education at Bearsden merged with the University and formed the University's Faculty of Education, which also incorporated the Departments of Adult and Continuing Education and Education, the Centre for Science Education, and the Teaching and Learning Service.",
        false,
        new int[] {R.drawable.ic_accessible, R.drawable.ic_wifi, R.drawable.ic_wc},
        55.8715,
        -4.2794,
            R.drawable.standrews
    ),
    KELVIN(
        "Kelvin Building",
        "The Kelvin Building, originally known as the Natural Philosophy Building, was named after Lord Kelvin and was designed by Scottish architect James Miller. The building was completed in 1906 and was formally opened by the Prince and Princess of Wales on 23 April 1907.",
        false,
        new int[] {R.drawable.ic_accessible, R.drawable.ic_wifi, R.drawable.ic_wc},
        55.8715,
        -4.2917,
            R.drawable.kelvin
    ),
    MAIN(
        "Main Building",
        "The new buildings were designed by George Gilbert Scott and erected around two quadrangles on top of the hill which had been previously occupied by Gilmorehill House. The new University buildings were inaugurated on 7 November 1870. The Bute and Randolph Halls were added 1878-1884 (designed by George Gilbert Scott, and completed after his death by J Oldrid Scott and Edwin Morgan), and the distinctive tower and spire was designed by J Oldrid Scott and erected 1887-1891.",
        false,
        new int[] {R.drawable.ic_accessible, R.drawable.ic_wifi, R.drawable.ic_wc, R.drawable.ic_local_cafe, R.drawable.ic_card_giftcard},
        55.8721,
        -4.2882,
            R.drawable.main
    ),
    LIBRARY(
        "Library",
        "The new Library building on Hillhead Street was designed by William Whitfield and completed 1968 under the stewardship of University Librarian Robert Ogilvie MacKenna, to replace the outgrown library accommodation in the north west Arts Quadrangle, now the Kelvin Gallery, of the Gilbert Scott Building.",
        false,
        new int[] {R.drawable.ic_accessible, R.drawable.ic_wifi, R.drawable.ic_wc, R.drawable.ic_local_cafe},
        55.8734,
        -4.2889,
            R.drawable.library
    );

    private String name;
    private String description;
    private boolean visited;
    private int[] facilities;
    private double latitude;
    private double longitude;
    private int image;

    Building(String name, String description, boolean visited, int[] facilities, double latitude, double longitude, int image) {
        this.name = name;
        this.description = description;
        this.visited = visited;
        this.facilities = facilities;
        this.latitude = latitude;
        this.longitude = longitude;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isVisited() {
        return visited;
    }

    public int[] getFacilities() {
        return facilities;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getImage(){ return  image;}

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}

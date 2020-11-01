package com.example.mersultrenurilor.dummy;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 25;

    static {
        addItem(new DummyItem("1","Bucuresti","Cluj",false,"23.08.2021 19:00","23.08.2021 10:00","IR123"));
        addItem(new DummyItem("2","Cluj","Botosani",true,"23.08.2021 19:00","23.08.2021 10:00","IR1234"));
        addItem(new DummyItem("3","Botosani","Iasi",false,"23.08.2021 19:00","23.08.2021 10:00","IR12345"));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }



    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;

        public final String destinatie;
        public final String plecare;
        public final boolean intarziere;
        public final String arrive;
        public final String departure;
        public final String numeTren;

        public DummyItem(String id, String destinatie, String plecare, boolean intarziere, String arrive, String departure, String numeTren) {
            this.id = id;
            this.destinatie = destinatie;
            this.plecare = plecare;
            this.intarziere = intarziere;
            this.arrive = arrive;
            this.departure = departure;
            this.numeTren = numeTren;
        }

        @Override
        public String toString() {
            return destinatie;
        }

        public String getId() {
            return id;
        }

        public String getDestinatie() {
            return destinatie;
        }

        public String getPlecare() {
            return plecare;
        }

        public boolean isIntarziere() {
            return intarziere;
        }

        public String getArrive() {
            return arrive;
        }

        public String getDeparture() {
            return departure;
        }

        public String getNumeTren() {
            return numeTren;
        }
    }
}
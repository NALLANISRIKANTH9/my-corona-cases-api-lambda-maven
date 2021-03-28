package com.nallani.my.corona.cases.api.lambda.maven.model;

public class CoronaCasesRequest {

        private String country;

        private String recovered;

        private String cases;

        private String critical;

        private String deathsPerOneMillion;

        private String active;

        private String casesPerOneMillion;

        private CountryInfo countryInfo;

        private String deaths;

        private String todayCases;

        private String todayDeaths;

        public String getCountry ()
        {
            return country;
        }

        public void setCountry (String country)
        {
            this.country = country;
        }

        public String getRecovered ()
        {
            return recovered;
        }

        public void setRecovered (String recovered)
        {
            this.recovered = recovered;
        }

        public String getCases ()
        {
            return cases;
        }

        public void setCases (String cases)
        {
            this.cases = cases;
        }

        public String getCritical ()
        {
            return critical;
        }

        public void setCritical (String critical)
        {
            this.critical = critical;
        }

        public String getDeathsPerOneMillion ()
        {
            return deathsPerOneMillion;
        }

        public void setDeathsPerOneMillion (String deathsPerOneMillion)
        {
            this.deathsPerOneMillion = deathsPerOneMillion;
        }

        public String getActive ()
        {
            return active;
        }

        public void setActive (String active)
        {
            this.active = active;
        }

        public String getCasesPerOneMillion ()
        {
            return casesPerOneMillion;
        }

        public void setCasesPerOneMillion (String casesPerOneMillion)
        {
            this.casesPerOneMillion = casesPerOneMillion;
        }

        public CountryInfo getCountryInfo ()
        {
            return countryInfo;
        }

        public void setCountryInfo (CountryInfo countryInfo)
        {
            this.countryInfo = countryInfo;
        }

        public String getDeaths ()
        {
            return deaths;
        }

        public void setDeaths (String deaths)
        {
            this.deaths = deaths;
        }

        public String getTodayCases ()
        {
            return todayCases;
        }

        public void setTodayCases (String todayCases)
        {
            this.todayCases = todayCases;
        }

        public String getTodayDeaths ()
        {
            return todayDeaths;
        }

        public void setTodayDeaths (String todayDeaths)
        {
            this.todayDeaths = todayDeaths;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [country = "+country+", recovered = "+recovered+", cases = "+cases+", critical = "+critical+", deathsPerOneMillion = "+deathsPerOneMillion+", active = "+active+", casesPerOneMillion = "+casesPerOneMillion+", countryInfo = "+countryInfo+", deaths = "+deaths+", todayCases = "+todayCases+", todayDeaths = "+todayDeaths+"]";
        }
}

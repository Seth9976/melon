package com.kakao.tiara.data;

public class Search {
    public static class Builder {
        Search search;

        public Builder() {
            this.search = new Search(null);
        }

        public Search build() {
            return this.search;
        }

        public Builder searchResultsNum(int v) {
            this.search.search_results_num = String.valueOf(v);
            return this;
        }

        public Builder searchTerm(String s) {
            this.search.search_term = s;
            return this;
        }

        public Builder searchType(String s) {
            this.search.search_type = s;
            return this;
        }
    }

    private String search_results_num;
    private String search_term;
    private String search_type;

    private Search() {
    }

    public Search(com.kakao.tiara.data.Search.1 search$10) {
    }

    class com.kakao.tiara.data.Search.1 {
    }

}


package com.rapidcode.api.common;

import java.util.List;

public class PageResponse<T> {
    private List<T> content;
    private int number;
    private int size;
    private long totalElements;
    private int totalPages;
    private boolean first;
    private boolean last;

    // Constructors
    public PageResponse() {}

    public PageResponse(List<T> content, int number, int size, long totalElements, int totalPages, boolean first, boolean last) {
        this.content = content;
        this.number = number;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.first = first;
        this.last = last;
    }

    // Getters
    public List<T> getContent() {
        return content;
    }

    public int getNumber() {
        return number;
    }

    public int getSize() {
        return size;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public boolean isFirst() {
        return first;
    }

    public boolean isLast() {
        return last;
    }

    // Setters
    public void setContent(List<T> content) {
        this.content = content;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    // Builder
    public static <T> PageResponseBuilder<T> builder() {
        return new PageResponseBuilder<>();
    }

    public static class PageResponseBuilder<T> {
        private List<T> content;
        private int number;
        private int size;
        private long totalElements;
        private int totalPages;
        private boolean first;
        private boolean last;

        public PageResponseBuilder<T> content(List<T> content) {
            this.content = content;
            return this;
        }

        public PageResponseBuilder<T> number(int number) {
            this.number = number;
            return this;
        }

        public PageResponseBuilder<T> size(int size) {
            this.size = size;
            return this;
        }

        public PageResponseBuilder<T> totalElements(long totalElements) {
            this.totalElements = totalElements;
            return this;
        }

        public PageResponseBuilder<T> totalPages(int totalPages) {
            this.totalPages = totalPages;
            return this;
        }

        public PageResponseBuilder<T> first(boolean first) {
            this.first = first;
            return this;
        }

        public PageResponseBuilder<T> last(boolean last) {
            this.last = last;
            return this;
        }

        public PageResponse<T> build() {
            return new PageResponse<>(content, number, size, totalElements, totalPages, first, last);
        }
    }
}
package com.example.livreson.Model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public enum Roles implements List<Role> {


        CLIENT,
        ADMIN;

        @Override
        public int size() {
                return 0;
        }

        @Override
        public boolean isEmpty() {
                return false;
        }

        @Override
        public boolean contains(Object o) {
                return false;
        }

        @Override
        public Iterator<Role> iterator() {
                return null;
        }

        @Override
        public Object[] toArray() {
                return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] ts) {
                return null;
        }

        @Override
        public boolean add(Role role) {
                return false;
        }

        @Override
        public boolean remove(Object o) {
                return false;
        }

        @Override
        public boolean containsAll(Collection<?> collection) {
                return false;
        }

        @Override
        public boolean addAll(Collection<? extends Role> collection) {
                return false;
        }

        @Override
        public boolean addAll(int i, Collection<? extends Role> collection) {
                return false;
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
                return false;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
                return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Role get(int i) {
                return null;
        }

        @Override
        public Role set(int i, Role role) {
                return null;
        }

        @Override
        public void add(int i, Role role) {

        }

        @Override
        public Role remove(int i) {
                return null;
        }

        @Override
        public int indexOf(Object o) {
                return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
                return 0;
        }

        @Override
        public ListIterator<Role> listIterator() {
                return null;
        }

        @Override
        public ListIterator<Role> listIterator(int i) {
                return null;
        }

        @Override
        public List<Role> subList(int i, int i1) {
                return null;
        }
}

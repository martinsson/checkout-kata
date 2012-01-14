(ns lean-challenge.test.core
  (:use [lean-challenge.core] :reload)
  (:use [midje.sweet]))

(fact
  true => false)
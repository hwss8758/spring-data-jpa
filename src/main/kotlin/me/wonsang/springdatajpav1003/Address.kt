package me.wonsang.springdatajpav1003

import javax.persistence.Embeddable

@Embeddable
class Address(var street: String = "",
              var city: String = "",
              var state: String = "",
              var zipCode: String = "") {
}
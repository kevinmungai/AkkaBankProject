package com.kevin.banking

import akka.actor._

object BankingActor {
  def props: Props = Props[BankingActor]

  case object CheckBalance
  case class Balance(amount: Int)

  case class Withdraw(amount: Int)
  case class Deposit(amount: Int)
}

class BankingActor extends Actor with ActorLogging {
  import BankingActor._

  var balance: Int = 0

  override def preStart(): Unit = log.info("BankingActor has Started!")

  override def postStop(): Unit = log.info("BankingActor has Stopped!")

  override def receive: Receive = {
    case CheckBalance =>
      log.info("Received CheckBalance Request!")
      log.info(s"Balance is $balance")
      //sender() ! Balance(balance)

    case Deposit(amount) =>
      log.info("Received Deposit Request!")
      balance += amount
      log.info(s"Balance is $balance")
      //sender() ! Balance(balance)

    case Withdraw(amount) =>
      log.info("Received Withdrawal Request!")
      balance -= amount
      log.info(s"Balance is $balance")
      //sender() ! Balance(balance)
  }
}

package org.knowm.xchange.bitcoinde;

import org.knowm.xchange.BaseExchange;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.bitcoinde.service.polling.BitcoindeMarketDataService;

import si.mazi.rescu.SynchronizedValueFactory;

/**
 * @author matthewdowney
 */
public class BitcoindeExchange extends BaseExchange implements Exchange {

  @Override
  public ExchangeSpecification getDefaultExchangeSpecification() {

    ExchangeSpecification exchangeSpecification = new ExchangeSpecification(this.getClass().getCanonicalName());
    exchangeSpecification.setSslUri("https://bitcoinapi.de/v1/");
    exchangeSpecification.setHost("bitcoin.de");
    exchangeSpecification.setPort(80);
    exchangeSpecification.setExchangeName("Bitcoin.de");
    exchangeSpecification.setExchangeDescription("Bitcoin.de is the largest bitcoin marketplace in Europe. All servers are located in Germany.");

    return exchangeSpecification;
  }

  @Override
  protected void initServices() {
    this.pollingMarketDataService = new BitcoindeMarketDataService(this);
    this.pollingTradeService = null;
    this.pollingAccountService = null;
  }

  @Override
  public SynchronizedValueFactory<Long> getNonceFactory() {

    // No private API implemented. Not needed for this exchange at the
    // moment.
    return null;
  }
}

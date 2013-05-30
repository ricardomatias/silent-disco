package de.nixis.web.disco.room;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

import io.netty.channel.Channel;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;

/**
 *
 * @author nico.rehwaldt
 */
public interface RoomContext {

  public Executor executor();

  public Channel channel();

  public Set<String> participantIds();

  public Set<Channel> channels();

  public Map<Channel, String> channelMap();

  public <T> Attribute<T> attr(AttributeKey<T> key);

  public String getRoomName();
}
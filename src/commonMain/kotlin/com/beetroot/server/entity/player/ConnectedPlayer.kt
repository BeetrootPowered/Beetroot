package com.beetroot.server.entity.player

import com.beetroot.server.network.NetworkConnection

class ConnectedPlayer(val connection: NetworkConnection) : Player() {

}
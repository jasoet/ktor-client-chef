/*
 * Copyright (C)2018 - Deny Prasetyo <jasoet87@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.yourcompany.boilerplate

import id.jasoet.funchef.chefApiClient
import io.ktor.client.request.get
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory

/**
 * Documentation of your class
 */
object Application {
    private val log = LoggerFactory.getLogger(Application::class.java)

    @JvmStatic
    fun main(args: Array<String>) = runBlocking<Unit> {
        val nodes = chefApiClient.get<Map<String, Any>>("/nodes/i-gopay-gitlab-runner-01")
        println(nodes["name"])
        println(nodes["chef_environment"])

        val roles = chefApiClient.get<Map<String, Any>>("/roles")
        println(roles)
    }
}

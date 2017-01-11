/*
 * Copyright (c) 2017, Digi International Inc.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, you can obtain one at http://mozilla.org/MPL/2.0/.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 *
 * Description: Recovery boot library
 *
 */

#ifndef RECOVERY_H
#define RECOVERY_H

/*
 * Configure recovery commands to update the firmware.
 *
 * Params:
 *   'swu_path' (input)  Path to the update package
 *
 * Return: 0 on sucess, -1 on failure
 */
int update_firmware(const char *swu_path);

/*
 * Reboot into recovery mode.
 *
 * Params:
 *   'reboot_timeout' (input)  Timeout to perform the reboot
 *
 * Return: -1 on failure, otherwise it does not return
 */
int reboot_recovery(unsigned int reboot_timeout);

/*
 * Configure recovery commands to format 'update' partition.
 *
 * Return: 0 on sucess, -1 on failure
 */
int wipe_update_partition(void);

#endif /* RECOVERY_H */
